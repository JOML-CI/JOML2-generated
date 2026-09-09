package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

/**
 * Generated implementation of {@link Byte2} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class Byte2Impl implements Byte2 {

    public byte x;
    public byte y;
    static final Byte2SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Byte2SegOpsUnsafe()
                    : new Byte2SegOpsMS();
    static final Byte2BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Byte2BbOpsUnsafe()
                    : new Byte2BbOpsApi();
    static final Byte2RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Byte2RawOpsUnsafe()
                    : new Byte2RawOpsApi();

    public Byte2Impl() {
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 add(Byte2R other, @Mutated Byte2 dest) {
        return add(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 add(Byte2R other, @Mutated Short2 dest) {
        return add(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 add(Byte2R other, @Mutated Int2 dest) {
        return add(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 add(Byte2R other, @Mutated Long2 dest) {
        return add(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 add(Byte2R other, @Mutated Double2 dest) {
        return add(other.x(), other.y(), dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 add(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (otherX + this.x);
        d.y = (byte) (otherY + this.y);
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 add(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (otherX + this.x);
        d.y = (short) (otherY + this.y);
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 add(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 add(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 add(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        return d;
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilDiv(byte scalar, @Mutated Byte2 dest) {
        return ceilDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilDiv(byte scalar, @Mutated Short2 dest) {
        return ceilDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilDiv(byte scalar, @Mutated Int2 dest) {
        return ceilDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilDiv(byte scalar, @Mutated Long2 dest) {
        return ceilDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilDiv(byte scalar, @Mutated Double2 dest) {
        return ceilDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilDiv(Byte2R other, @Mutated Byte2 dest) {
        return ceilDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilDiv(Byte2R other, @Mutated Short2 dest) {
        return ceilDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilDiv(Byte2R other, @Mutated Int2 dest) {
        return ceilDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilDiv(Byte2R other, @Mutated Long2 dest) {
        return ceilDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilDiv(Byte2R other, @Mutated Double2 dest) {
        return ceilDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling division of this vector by ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilDiv(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (java.lang.Math.ceilDiv(this.x, otherX));
        d.y = (byte) (java.lang.Math.ceilDiv(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise ceiling division of this vector by ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilDiv(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (java.lang.Math.ceilDiv(this.x, otherX));
        d.y = (short) (java.lang.Math.ceilDiv(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise ceiling division of this vector by ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilDiv(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = java.lang.Math.ceilDiv(this.x, otherX);
        d.y = java.lang.Math.ceilDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise ceiling division of this vector by ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilDiv(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = java.lang.Math.ceilDiv(this.x, otherX);
        d.y = java.lang.Math.ceilDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise ceiling division of this vector by ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilDiv(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = java.lang.Math.ceilDiv(this.x, otherX);
        d.y = java.lang.Math.ceilDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilMod(byte scalar, @Mutated Byte2 dest) {
        return ceilMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilMod(byte scalar, @Mutated Short2 dest) {
        return ceilMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilMod(byte scalar, @Mutated Int2 dest) {
        return ceilMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilMod(byte scalar, @Mutated Long2 dest) {
        return ceilMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilMod(byte scalar, @Mutated Double2 dest) {
        return ceilMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilMod(Byte2R other, @Mutated Byte2 dest) {
        return ceilMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilMod(Byte2R other, @Mutated Short2 dest) {
        return ceilMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilMod(Byte2R other, @Mutated Int2 dest) {
        return ceilMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilMod(Byte2R other, @Mutated Long2 dest) {
        return ceilMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilMod(Byte2R other, @Mutated Double2 dest) {
        return ceilMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ceilMod(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (java.lang.Math.ceilMod(this.x, otherX));
        d.y = (byte) (java.lang.Math.ceilMod(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ceilMod(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (java.lang.Math.ceilMod(this.x, otherX));
        d.y = (short) (java.lang.Math.ceilMod(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ceilMod(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = java.lang.Math.ceilMod(this.x, otherX);
        d.y = java.lang.Math.ceilMod(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ceilMod(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = java.lang.Math.ceilMod(this.x, otherX);
        d.y = java.lang.Math.ceilMod(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code otherX},
     * {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ceilMod(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = java.lang.Math.ceilMod(this.x, otherX);
        d.y = java.lang.Math.ceilMod(this.y, otherY);
        return d;
    }


    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 div(byte scalar, @Mutated Byte2 dest) {
        return div(scalar, scalar, dest);
    }


    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 div(byte scalar, @Mutated Short2 dest) {
        return div(scalar, scalar, dest);
    }


    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 div(byte scalar, @Mutated Int2 dest) {
        return div(scalar, scalar, dest);
    }


    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 div(byte scalar, @Mutated Long2 dest) {
        return div(scalar, scalar, dest);
    }


    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 div(byte scalar, @Mutated Double2 dest) {
        return div(scalar, scalar, dest);
    }


    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 div(Byte2R other, @Mutated Byte2 dest) {
        return div(other.x(), other.y(), dest);
    }


    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 div(Byte2R other, @Mutated Short2 dest) {
        return div(other.x(), other.y(), dest);
    }


    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 div(Byte2R other, @Mutated Int2 dest) {
        return div(other.x(), other.y(), dest);
    }


    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 div(Byte2R other, @Mutated Long2 dest) {
        return div(other.x(), other.y(), dest);
    }


    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 div(Byte2R other, @Mutated Double2 dest) {
        return div(other.x(), other.y(), dest);
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}) (integer division,
     * truncating toward zero) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 div(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x / otherX);
        d.y = (byte) (this.y / otherY);
        return d;
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}) (integer division,
     * truncating toward zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 div(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x / otherX);
        d.y = (short) (this.y / otherY);
        return d;
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}) (integer division,
     * truncating toward zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 div(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        return d;
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}) (integer division,
     * truncating toward zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 div(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        return d;
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}) (integer division,
     * truncating toward zero) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 div(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        return d;
    }


    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorDiv(byte scalar, @Mutated Byte2 dest) {
        return floorDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorDiv(byte scalar, @Mutated Short2 dest) {
        return floorDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorDiv(byte scalar, @Mutated Int2 dest) {
        return floorDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorDiv(byte scalar, @Mutated Long2 dest) {
        return floorDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorDiv(byte scalar, @Mutated Double2 dest) {
        return floorDiv(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorDiv(Byte2R other, @Mutated Byte2 dest) {
        return floorDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorDiv(Byte2R other, @Mutated Short2 dest) {
        return floorDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorDiv(Byte2R other, @Mutated Int2 dest) {
        return floorDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorDiv(Byte2R other, @Mutated Long2 dest) {
        return floorDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorDiv(Byte2R other, @Mutated Double2 dest) {
        return floorDiv(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor division of this vector by ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorDiv(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.floorDiv(this.x, otherX));
        d.y = (byte) (Math.floorDiv(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise floor division of this vector by ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorDiv(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.floorDiv(this.x, otherX));
        d.y = (short) (Math.floorDiv(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise floor division of this vector by ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorDiv(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.floorDiv(this.x, otherX);
        d.y = Math.floorDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise floor division of this vector by ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorDiv(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.floorDiv(this.x, otherX);
        d.y = Math.floorDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise floor division of this vector by ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorDiv(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.floorDiv(this.x, otherX);
        d.y = Math.floorDiv(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorMod(byte scalar, @Mutated Byte2 dest) {
        return floorMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorMod(byte scalar, @Mutated Short2 dest) {
        return floorMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorMod(byte scalar, @Mutated Int2 dest) {
        return floorMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorMod(byte scalar, @Mutated Long2 dest) {
        return floorMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorMod(byte scalar, @Mutated Double2 dest) {
        return floorMod(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorMod(Byte2R other, @Mutated Byte2 dest) {
        return floorMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorMod(Byte2R other, @Mutated Short2 dest) {
        return floorMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorMod(Byte2R other, @Mutated Int2 dest) {
        return floorMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorMod(Byte2R other, @Mutated Long2 dest) {
        return floorMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorMod(Byte2R other, @Mutated Double2 dest) {
        return floorMod(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise floor modulus of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 floorMod(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.floorMod(this.x, otherX));
        d.y = (byte) (Math.floorMod(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise floor modulus of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 floorMod(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.floorMod(this.x, otherX));
        d.y = (short) (Math.floorMod(this.y, otherY));
        return d;
    }


    /**
     * Compute the component-wise floor modulus of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 floorMod(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.floorMod(this.x, otherX);
        d.y = Math.floorMod(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise floor modulus of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 floorMod(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.floorMod(this.x, otherX);
        d.y = Math.floorMod(this.y, otherY);
        return d;
    }


    /**
     * Compute the component-wise floor modulus of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 floorMod(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.floorMod(this.x, otherX);
        d.y = Math.floorMod(this.y, otherY);
        return d;
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 mul(byte scalar, @Mutated Byte2 dest) {
        return mul(scalar, scalar, dest);
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 mul(byte scalar, @Mutated Short2 dest) {
        return mul(scalar, scalar, dest);
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 mul(byte scalar, @Mutated Int2 dest) {
        return mul(scalar, scalar, dest);
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 mul(byte scalar, @Mutated Long2 dest) {
        return mul(scalar, scalar, dest);
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 mul(byte scalar, @Mutated Double2 dest) {
        return mul(scalar, scalar, dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 mul(Byte2R other, @Mutated Byte2 dest) {
        return mul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 mul(Byte2R other, @Mutated Short2 dest) {
        return mul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 mul(Byte2R other, @Mutated Int2 dest) {
        return mul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 mul(Byte2R other, @Mutated Long2 dest) {
        return mul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 mul(Byte2R other, @Mutated Double2 dest) {
        return mul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}) and store the result
     * in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 mul(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (otherX * this.x);
        d.y = (byte) (otherY * this.y);
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 mul(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (otherX * this.x);
        d.y = (short) (otherY * this.y);
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 mul(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 mul(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 mul(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 negate(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (-this.x);
        d.y = (byte) (-this.y);
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 negate(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (-this.x);
        d.y = (short) (-this.y);
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 negate(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 negate(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 negate(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        return d;
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 rem(byte scalar, @Mutated Byte2 dest) {
        return rem(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 rem(byte scalar, @Mutated Short2 dest) {
        return rem(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 rem(byte scalar, @Mutated Int2 dest) {
        return rem(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 rem(byte scalar, @Mutated Long2 dest) {
        return rem(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 rem(byte scalar, @Mutated Double2 dest) {
        return rem(scalar, scalar, dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 rem(Byte2R other, @Mutated Byte2 dest) {
        return rem(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 rem(Byte2R other, @Mutated Short2 dest) {
        return rem(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 rem(Byte2R other, @Mutated Int2 dest) {
        return rem(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 rem(Byte2R other, @Mutated Long2 dest) {
        return rem(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 rem(Byte2R other, @Mutated Double2 dest) {
        return rem(other.x(), other.y(), dest);
    }


    /**
     * Compute the component-wise truncated remainder of this vector and ({@code otherX},
     * {@code otherY}) (the remainder carries the sign of the dividend, exactly Java's {@code %}, so
     * it pairs with {@code div}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 rem(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x % otherX);
        d.y = (byte) (this.y % otherY);
        return d;
    }


    /**
     * Compute the component-wise truncated remainder of this vector and ({@code otherX},
     * {@code otherY}) (the remainder carries the sign of the dividend, exactly Java's {@code %}, so
     * it pairs with {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 rem(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x % otherX);
        d.y = (short) (this.y % otherY);
        return d;
    }


    /**
     * Compute the component-wise truncated remainder of this vector and ({@code otherX},
     * {@code otherY}) (the remainder carries the sign of the dividend, exactly Java's {@code %}, so
     * it pairs with {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 rem(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x % otherX;
        d.y = this.y % otherY;
        return d;
    }


    /**
     * Compute the component-wise truncated remainder of this vector and ({@code otherX},
     * {@code otherY}) (the remainder carries the sign of the dividend, exactly Java's {@code %}, so
     * it pairs with {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 rem(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x % otherX;
        d.y = this.y % otherY;
        return d;
    }


    /**
     * Compute the component-wise truncated remainder of this vector and ({@code otherX},
     * {@code otherY}) (the remainder carries the sign of the dividend, exactly Java's {@code %}, so
     * it pairs with {@code div}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 rem(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x % otherX;
        d.y = this.y % otherY;
        return d;
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 sub(Byte2R other, @Mutated Byte2 dest) {
        return sub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 sub(Byte2R other, @Mutated Short2 dest) {
        return sub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 sub(Byte2R other, @Mutated Int2 dest) {
        return sub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 sub(Byte2R other, @Mutated Long2 dest) {
        return sub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 sub(Byte2R other, @Mutated Double2 dest) {
        return sub(other.x(), other.y(), dest);
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 sub(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x - otherX);
        d.y = (byte) (this.y - otherY);
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 sub(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x - otherX);
        d.y = (short) (this.y - otherY);
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 sub(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 sub(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 sub(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        return d;
    }


    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 and(Byte2R other, @Mutated Byte2 dest) {
        return and(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 and(Byte2R other, @Mutated Short2 dest) {
        return and(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 and(Byte2R other, @Mutated Int2 dest) {
        return and(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 and(Byte2R other, @Mutated Long2 dest) {
        return and(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 and(Byte2R other, @Mutated Double2 dest) {
        return and(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise AND of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 and(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x & otherX);
        d.y = (byte) (this.y & otherY);
        return d;
    }


    /**
     * Compute the bitwise AND of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 and(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x & otherX);
        d.y = (short) (this.y & otherY);
        return d;
    }


    /**
     * Compute the bitwise AND of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 and(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x & otherX;
        d.y = this.y & otherY;
        return d;
    }


    /**
     * Compute the bitwise AND of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 and(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x & otherX;
        d.y = this.y & otherY;
        return d;
    }


    /**
     * Compute the bitwise AND of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 and(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x & otherX;
        d.y = this.y & otherY;
        return d;
    }


    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 bitCount(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.bitCount(this.x));
        d.y = (byte) (Math.bitCount(this.y));
        return d;
    }


    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 bitCount(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.bitCount(this.x));
        d.y = (short) (Math.bitCount(this.y));
        return d;
    }


    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 bitCount(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.bitCount(this.x);
        d.y = Math.bitCount(this.y);
        return d;
    }


    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 bitCount(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.bitCount(this.x);
        d.y = Math.bitCount(this.y);
        return d;
    }


    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 bitCount(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.bitCount(this.x);
        d.y = Math.bitCount(this.y);
        return d;
    }


    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 not(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (~this.x);
        d.y = (byte) (~this.y);
        return d;
    }


    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 not(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (~this.x);
        d.y = (short) (~this.y);
        return d;
    }


    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 not(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = ~this.x;
        d.y = ~this.y;
        return d;
    }


    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 not(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = ~this.x;
        d.y = ~this.y;
        return d;
    }


    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 not(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = ~this.x;
        d.y = ~this.y;
        return d;
    }


    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 numberOfLeadingZeros(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.numberOfLeadingZeros(this.x));
        d.y = (byte) (Math.numberOfLeadingZeros(this.y));
        return d;
    }


    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 numberOfLeadingZeros(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.numberOfLeadingZeros(this.x));
        d.y = (short) (Math.numberOfLeadingZeros(this.y));
        return d;
    }


    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 numberOfLeadingZeros(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.numberOfLeadingZeros(this.x);
        d.y = Math.numberOfLeadingZeros(this.y);
        return d;
    }


    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 numberOfLeadingZeros(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.numberOfLeadingZeros(this.x);
        d.y = Math.numberOfLeadingZeros(this.y);
        return d;
    }


    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 numberOfLeadingZeros(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.numberOfLeadingZeros(this.x);
        d.y = Math.numberOfLeadingZeros(this.y);
        return d;
    }


    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 numberOfTrailingZeros(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.numberOfTrailingZeros(this.x));
        d.y = (byte) (Math.numberOfTrailingZeros(this.y));
        return d;
    }


    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 numberOfTrailingZeros(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.numberOfTrailingZeros(this.x));
        d.y = (short) (Math.numberOfTrailingZeros(this.y));
        return d;
    }


    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 numberOfTrailingZeros(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.numberOfTrailingZeros(this.x);
        d.y = Math.numberOfTrailingZeros(this.y);
        return d;
    }


    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 numberOfTrailingZeros(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.numberOfTrailingZeros(this.x);
        d.y = Math.numberOfTrailingZeros(this.y);
        return d;
    }


    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 numberOfTrailingZeros(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.numberOfTrailingZeros(this.x);
        d.y = Math.numberOfTrailingZeros(this.y);
        return d;
    }


    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 or(Byte2R other, @Mutated Byte2 dest) {
        return or(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 or(Byte2R other, @Mutated Short2 dest) {
        return or(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 or(Byte2R other, @Mutated Int2 dest) {
        return or(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 or(Byte2R other, @Mutated Long2 dest) {
        return or(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 or(Byte2R other, @Mutated Double2 dest) {
        return or(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise OR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 or(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x | otherX);
        d.y = (byte) (this.y | otherY);
        return d;
    }


    /**
     * Compute the bitwise OR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 or(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x | otherX);
        d.y = (short) (this.y | otherY);
        return d;
    }


    /**
     * Compute the bitwise OR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 or(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x | otherX;
        d.y = this.y | otherY;
        return d;
    }


    /**
     * Compute the bitwise OR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 or(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x | otherX;
        d.y = this.y | otherY;
        return d;
    }


    /**
     * Compute the bitwise OR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 or(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x | otherX;
        d.y = this.y | otherY;
        return d;
    }


    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 reverseBits(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.reverseBits(this.x));
        d.y = (byte) (Math.reverseBits(this.y));
        return d;
    }


    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 reverseBits(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.reverseBits(this.x));
        d.y = (short) (Math.reverseBits(this.y));
        return d;
    }


    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 reverseBits(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.reverseBits(this.x);
        d.y = Math.reverseBits(this.y);
        return d;
    }


    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 reverseBits(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.reverseBits(this.x);
        d.y = Math.reverseBits(this.y);
        return d;
    }


    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 reverseBits(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.reverseBits(this.x);
        d.y = Math.reverseBits(this.y);
        return d;
    }


    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 reverseBytes(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.reverseBytes(this.x));
        d.y = (byte) (Math.reverseBytes(this.y));
        return d;
    }


    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 reverseBytes(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.reverseBytes(this.x));
        d.y = (short) (Math.reverseBytes(this.y));
        return d;
    }


    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 reverseBytes(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.reverseBytes(this.x);
        d.y = Math.reverseBytes(this.y);
        return d;
    }


    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 reverseBytes(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.reverseBytes(this.x);
        d.y = Math.reverseBytes(this.y);
        return d;
    }


    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 reverseBytes(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.reverseBytes(this.x);
        d.y = Math.reverseBytes(this.y);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 rotateLeft(byte distance, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.rotateLeft(this.x, distance));
        d.y = (byte) (Math.rotateLeft(this.y, distance));
        return d;
    }


    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Short2 rotateLeft(byte distance, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.rotateLeft(this.x, distance));
        d.y = (short) (Math.rotateLeft(this.y, distance));
        return d;
    }


    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Int2 rotateLeft(byte distance, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.rotateLeft(this.x, distance);
        d.y = Math.rotateLeft(this.y, distance);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Long2 rotateLeft(byte distance, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.rotateLeft(this.x, distance);
        d.y = Math.rotateLeft(this.y, distance);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Double2 rotateLeft(byte distance, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.rotateLeft(this.x, distance);
        d.y = Math.rotateLeft(this.y, distance);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 rotateRight(byte distance, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.rotateRight(this.x, distance));
        d.y = (byte) (Math.rotateRight(this.y, distance));
        return d;
    }


    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code short}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Short2 rotateRight(byte distance, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.rotateRight(this.x, distance));
        d.y = (short) (Math.rotateRight(this.y, distance));
        return d;
    }


    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code int}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Int2 rotateRight(byte distance, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.rotateRight(this.x, distance);
        d.y = Math.rotateRight(this.y, distance);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code long}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Long2 rotateRight(byte distance, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.rotateRight(this.x, distance);
        d.y = Math.rotateRight(this.y, distance);
        return d;
    }


    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     * <p>
     * The operation is evaluated on the {@code byte} lane of 8 bits - bit counts, reversals and
     * rotations are relative to that width, not to the 32 bits of {@code int} - and each result
     * component is then widened to {@code double}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    public Double2 rotateRight(byte distance, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.rotateRight(this.x, distance);
        d.y = Math.rotateRight(this.y, distance);
        return d;
    }


    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32) and store the result in {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 shl(byte shift, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x << (shift & 7));
        d.y = (byte) (this.y << (shift & 7));
        return d;
    }


    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Short2 shl(byte shift, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x << (shift & 7));
        d.y = (short) (this.y << (shift & 7));
        return d;
    }


    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Int2 shl(byte shift, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x << (shift & 7);
        d.y = this.y << (shift & 7);
        return d;
    }


    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Long2 shl(byte shift, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x << (shift & 7);
        d.y = this.y << (shift & 7);
        return d;
    }


    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Double2 shl(byte shift, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x << (shift & 7);
        d.y = this.y << (shift & 7);
        return d;
    }


    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32) and store the result in {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 shr(byte shift, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x >> (shift & 7));
        d.y = (byte) (this.y >> (shift & 7));
        return d;
    }


    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Short2 shr(byte shift, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x >> (shift & 7));
        d.y = (short) (this.y >> (shift & 7));
        return d;
    }


    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Int2 shr(byte shift, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x >> (shift & 7);
        d.y = this.y >> (shift & 7);
        return d;
    }


    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Long2 shr(byte shift, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x >> (shift & 7);
        d.y = this.y >> (shift & 7);
        return d;
    }


    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Double2 shr(byte shift, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x >> (shift & 7);
        d.y = this.y >> (shift & 7);
        return d;
    }


    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32) and store the result in {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 ushr(byte shift, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) ((this.x & 0xFF) >>> (shift & 7));
        d.y = (byte) ((this.y & 0xFF) >>> (shift & 7));
        return d;
    }


    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Short2 ushr(byte shift, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) ((this.x & 0xFF) >>> (shift & 7));
        d.y = (short) ((this.y & 0xFF) >>> (shift & 7));
        return d;
    }


    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Int2 ushr(byte shift, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = (this.x & 0xFF) >>> (shift & 7);
        d.y = (this.y & 0xFF) >>> (shift & 7);
        return d;
    }


    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}. The shift count
     * is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Long2 ushr(byte shift, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = (this.x & 0xFF) >>> (shift & 7);
        d.y = (this.y & 0xFF) >>> (shift & 7);
        return d;
    }


    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}. The shift
     * count is still taken modulo this vector's lane width of 8, not the destination's.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    public Double2 ushr(byte shift, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = (this.x & 0xFF) >>> (shift & 7);
        d.y = (this.y & 0xFF) >>> (shift & 7);
        return d;
    }


    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 xor(Byte2R other, @Mutated Byte2 dest) {
        return xor(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 xor(Byte2R other, @Mutated Short2 dest) {
        return xor(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 xor(Byte2R other, @Mutated Int2 dest) {
        return xor(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 xor(Byte2R other, @Mutated Long2 dest) {
        return xor(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 xor(Byte2R other, @Mutated Double2 dest) {
        return xor(other.x(), other.y(), dest);
    }


    /**
     * Compute the bitwise XOR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 xor(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (this.x ^ otherX);
        d.y = (byte) (this.y ^ otherY);
        return d;
    }


    /**
     * Compute the bitwise XOR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 xor(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x ^ otherX);
        d.y = (short) (this.y ^ otherY);
        return d;
    }


    /**
     * Compute the bitwise XOR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 xor(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x ^ otherX;
        d.y = this.y ^ otherY;
        return d;
    }


    /**
     * Compute the bitwise XOR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 xor(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x ^ otherX;
        d.y = this.y ^ otherY;
        return d;
    }


    /**
     * Compute the bitwise XOR of each component of this vector and ({@code otherX}, {@code otherY})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 xor(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x ^ otherX;
        d.y = this.y ^ otherY;
        return d;
    }


    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Byte2 set(Byte2R v) {
        return set(v.x(), v.y());
    }


    /**
     * Set this vector to the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Byte2 set(byte vX, byte vY) {
        this.x = (byte) (vX);
        this.y = (byte) (vY);
        return this;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 set(byte s, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (s);
        d.y = (byte) (s);
        return d;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Short2 set(byte s, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (s);
        d.y = (short) (s);
        return d;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Int2 set(byte s, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = s;
        d.y = s;
        return d;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Long2 set(byte s, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = s;
        d.y = s;
        return d;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Double2 set(byte s, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = s;
        d.y = s;
        return d;
    }


    /**
     * Convert this vector to {@code float} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2 toFloat(@Mutated Float2 dest) {
        Float2Impl d = (Float2Impl) dest;
        d.x = this.x;
        d.y = this.y;
        return d;
    }


    /**
     * Convert this vector to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 toDouble(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.x;
        d.y = this.y;
        return d;
    }


    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 toShort(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (this.x);
        d.y = (short) (this.y);
        return d;
    }


    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 toInt(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.x;
        d.y = this.y;
        return d;
    }


    /**
     * Convert this vector to {@code long} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 toLong(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.x;
        d.y = this.y;
        return d;
    }


    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated public Byte2 makeZero() {
        this.x = (byte) (0);
        this.y = (byte) (0);
        return this;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 absolute(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.abs(this.x));
        d.y = (byte) (Math.abs(this.y));
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 absolute(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.abs(this.x));
        d.y = (short) (Math.abs(this.y));
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 absolute(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 absolute(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 absolute(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 clamp(byte min, byte max, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.min(Math.max(this.x, min), max));
        d.y = (byte) (Math.min(Math.max(this.y, min), max));
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Short2 clamp(byte min, byte max, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.min(Math.max(this.x, min), max));
        d.y = (short) (Math.min(Math.max(this.y, min), max));
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Int2 clamp(byte min, byte max, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Long2 clamp(byte min, byte max, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Double2 clamp(byte min, byte max, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 clamp(Byte2R min, Byte2R max, @Mutated Byte2 dest) {
        return clamp(min.x(), min.y(), max.x(), max.y(), dest);
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Short2 clamp(Byte2R min, Byte2R max, @Mutated Short2 dest) {
        return clamp(min.x(), min.y(), max.x(), max.y(), dest);
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Int2 clamp(Byte2R min, Byte2R max, @Mutated Int2 dest) {
        return clamp(min.x(), min.y(), max.x(), max.y(), dest);
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Long2 clamp(Byte2R min, Byte2R max, @Mutated Long2 dest) {
        return clamp(min.x(), min.y(), max.x(), max.y(), dest);
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Double2 clamp(Byte2R min, Byte2R max, @Mutated Double2 dest) {
        return clamp(min.x(), min.y(), max.x(), max.y(), dest);
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 clamp(byte minX, byte minY, byte maxX, byte maxY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.min(Math.max(this.x, minX), maxX));
        d.y = (byte) (Math.min(Math.max(this.y, minY), maxY));
        return d;
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 clamp(byte minX, byte minY, byte maxX, byte maxY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.min(Math.max(this.x, minX), maxX));
        d.y = (short) (Math.min(Math.max(this.y, minY), maxY));
        return d;
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 clamp(byte minX, byte minY, byte maxX, byte maxY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        return d;
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 clamp(byte minX, byte minY, byte maxX, byte maxY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        return d;
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 clamp(byte minX, byte minY, byte maxX, byte maxY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        return d;
    }


    /**
     * Compute the sum of all components of this vector.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @return the sum of all components of this vector
     */
    public byte compAdd() {
        return (byte) (this.x + this.y);
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public byte compMax() {
        return (byte) (Math.max(this.x, this.y));
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public byte compMin() {
        return (byte) (Math.min(this.x, this.y));
    }


    /**
     * Compute the product of all components of this vector.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @return the product of all components of this vector
     */
    public byte compMul() {
        return (byte) (this.x * this.y);
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public byte distanceSquared(Byte2R other) {
        return distanceSquared(other.x(), other.y());
    }


    /**
     * Compute the squared distance between this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the squared distance between this vector and ({@code otherX}, {@code otherY})
     */
    public byte distanceSquared(byte otherX, byte otherY) {
        byte _t0 = (byte) (this.x - otherX);
        byte _t1 = (byte) (this.y - otherY);
        return (byte) (_t0 * _t0 + _t1 * _t1);
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public byte dot(Byte2R other) {
        return dot(other.x(), other.y());
    }


    /**
     * Compute the dot product of this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the dot product of this vector and ({@code otherX}, {@code otherY})
     */
    public byte dot(byte otherX, byte otherY) {
        return (byte) (otherX * this.x + otherY * this.y);
    }


    /**
     * Compute the squared length of this vector.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @return the squared length of this vector
     */
    public byte lengthSquared() {
        return (byte) (this.x * this.x + this.y * this.y);
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public byte manhattanDistance(Byte2R other) {
        return manhattanDistance(other.x(), other.y());
    }


    /**
     * Compute the Manhattan distance between this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the Manhattan distance between this vector and ({@code otherX}, {@code otherY})
     */
    public byte manhattanDistance(byte otherX, byte otherY) {
        return (byte) (Math.abs(this.x - otherX) + Math.abs(this.y - otherY));
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     * <p>
     * The value is computed at {@code int} precision and narrowed to {@code byte} on return, so a
     * result outside the {@code byte} range wraps.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public byte manhattanLength() {
        return (byte) (Math.abs(this.x) + Math.abs(this.y));
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 max(byte scalar, @Mutated Byte2 dest) {
        return max(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 max(byte scalar, @Mutated Short2 dest) {
        return max(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 max(byte scalar, @Mutated Int2 dest) {
        return max(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 max(byte scalar, @Mutated Long2 dest) {
        return max(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 max(byte scalar, @Mutated Double2 dest) {
        return max(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 max(Byte2R other, @Mutated Byte2 dest) {
        return max(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 max(Byte2R other, @Mutated Short2 dest) {
        return max(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 max(Byte2R other, @Mutated Int2 dest) {
        return max(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 max(Byte2R other, @Mutated Long2 dest) {
        return max(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 max(Byte2R other, @Mutated Double2 dest) {
        return max(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 max(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.max(this.x, otherX));
        d.y = (byte) (Math.max(this.y, otherY));
        return d;
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 max(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.max(this.x, otherX));
        d.y = (short) (Math.max(this.y, otherY));
        return d;
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 max(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        return d;
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 max(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        return d;
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 max(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 min(byte scalar, @Mutated Byte2 dest) {
        return min(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Short2 min(byte scalar, @Mutated Short2 dest) {
        return min(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Int2 min(byte scalar, @Mutated Int2 dest) {
        return min(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Long2 min(byte scalar, @Mutated Long2 dest) {
        return min(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double2 min(byte scalar, @Mutated Double2 dest) {
        return min(scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 min(Byte2R other, @Mutated Byte2 dest) {
        return min(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 min(Byte2R other, @Mutated Short2 dest) {
        return min(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 min(Byte2R other, @Mutated Int2 dest) {
        return min(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 min(Byte2R other, @Mutated Long2 dest) {
        return min(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 min(Byte2R other, @Mutated Double2 dest) {
        return min(other.x(), other.y(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 min(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.min(this.x, otherX));
        d.y = (byte) (Math.min(this.y, otherY));
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 min(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.min(this.x, otherX));
        d.y = (short) (Math.min(this.y, otherY));
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 min(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 min(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 min(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 sign(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (Math.signum(this.x));
        d.y = (byte) (Math.signum(this.y));
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 sign(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (Math.signum(this.x));
        d.y = (short) (Math.signum(this.y));
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 sign(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 sign(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision - Java promotes {@code byte} operands
     * before evaluating - and each result component is then stored as {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 sign(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        return d;
    }


    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satAdd(Byte2R other, @Mutated Byte2 dest) {
        return satAdd(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satAdd(Byte2R other, @Mutated Short2 dest) {
        return satAdd(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satAdd(Byte2R other, @Mutated Int2 dest) {
        return satAdd(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satAdd(Byte2R other, @Mutated Long2 dest) {
        return satAdd(other.x(), other.y(), dest);
    }


    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satAdd(Byte2R other, @Mutated Double2 dest) {
        return satAdd(other.x(), other.y(), dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satAdd(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (org.joml2.SaturatingMath.satAddB(this.x, otherX));
        d.y = (byte) (org.joml2.SaturatingMath.satAddB(this.y, otherY));
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satAdd(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (org.joml2.SaturatingMath.satAddB(this.x, otherX));
        d.y = (short) (org.joml2.SaturatingMath.satAddB(this.y, otherY));
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satAdd(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = org.joml2.SaturatingMath.satAddB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satAddB(this.y, otherY);
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satAdd(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = org.joml2.SaturatingMath.satAddB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satAddB(this.y, otherY);
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satAdd(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = org.joml2.SaturatingMath.satAddB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satAddB(this.y, otherY);
        return d;
    }


    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satMul(Byte2R other, @Mutated Byte2 dest) {
        return satMul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satMul(Byte2R other, @Mutated Short2 dest) {
        return satMul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satMul(Byte2R other, @Mutated Int2 dest) {
        return satMul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satMul(Byte2R other, @Mutated Long2 dest) {
        return satMul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satMul(Byte2R other, @Mutated Double2 dest) {
        return satMul(other.x(), other.y(), dest);
    }


    /**
     * Multiply this vector by ({@code otherX}, {@code otherY}), clamping to the value range instead
     * of overflowing and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satMul(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (org.joml2.SaturatingMath.satMulB(this.x, otherX));
        d.y = (byte) (org.joml2.SaturatingMath.satMulB(this.y, otherY));
        return d;
    }


    /**
     * Multiply this vector by ({@code otherX}, {@code otherY}), clamping to the value range instead
     * of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satMul(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (org.joml2.SaturatingMath.satMulB(this.x, otherX));
        d.y = (short) (org.joml2.SaturatingMath.satMulB(this.y, otherY));
        return d;
    }


    /**
     * Multiply this vector by ({@code otherX}, {@code otherY}), clamping to the value range instead
     * of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satMul(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = org.joml2.SaturatingMath.satMulB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satMulB(this.y, otherY);
        return d;
    }


    /**
     * Multiply this vector by ({@code otherX}, {@code otherY}), clamping to the value range instead
     * of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satMul(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = org.joml2.SaturatingMath.satMulB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satMulB(this.y, otherY);
        return d;
    }


    /**
     * Multiply this vector by ({@code otherX}, {@code otherY}), clamping to the value range instead
     * of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satMul(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = org.joml2.SaturatingMath.satMulB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satMulB(this.y, otherY);
        return d;
    }


    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satNegate(@Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (org.joml2.SaturatingMath.satNegB(this.x));
        d.y = (byte) (org.joml2.SaturatingMath.satNegB(this.y));
        return d;
    }


    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satNegate(@Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (org.joml2.SaturatingMath.satNegB(this.x));
        d.y = (short) (org.joml2.SaturatingMath.satNegB(this.y));
        return d;
    }


    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satNegate(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = org.joml2.SaturatingMath.satNegB(this.x);
        d.y = org.joml2.SaturatingMath.satNegB(this.y);
        return d;
    }


    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satNegate(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = org.joml2.SaturatingMath.satNegB(this.x);
        d.y = org.joml2.SaturatingMath.satNegB(this.y);
        return d;
    }


    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satNegate(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = org.joml2.SaturatingMath.satNegB(this.x);
        d.y = org.joml2.SaturatingMath.satNegB(this.y);
        return d;
    }


    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satSub(Byte2R other, @Mutated Byte2 dest) {
        return satSub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satSub(Byte2R other, @Mutated Short2 dest) {
        return satSub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satSub(Byte2R other, @Mutated Int2 dest) {
        return satSub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satSub(Byte2R other, @Mutated Long2 dest) {
        return satSub(other.x(), other.y(), dest);
    }


    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satSub(Byte2R other, @Mutated Double2 dest) {
        return satSub(other.x(), other.y(), dest);
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, clamping to the value range
     * instead of overflowing and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Byte2 satSub(byte otherX, byte otherY, @Mutated Byte2 dest) {
        Byte2Impl d = (Byte2Impl) dest;
        d.x = (byte) (org.joml2.SaturatingMath.satSubB(this.x, otherX));
        d.y = (byte) (org.joml2.SaturatingMath.satSubB(this.y, otherY));
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, clamping to the value range
     * instead of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code short}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Short2 satSub(byte otherX, byte otherY, @Mutated Short2 dest) {
        Short2Impl d = (Short2Impl) dest;
        d.x = (short) (org.joml2.SaturatingMath.satSubB(this.x, otherX));
        d.y = (short) (org.joml2.SaturatingMath.satSubB(this.y, otherY));
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, clamping to the value range
     * instead of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code int}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 satSub(byte otherX, byte otherY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = org.joml2.SaturatingMath.satSubB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satSubB(this.y, otherY);
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, clamping to the value range
     * instead of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code long}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 satSub(byte otherX, byte otherY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = org.joml2.SaturatingMath.satSubB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satSubB(this.y, otherY);
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, clamping to the value range
     * instead of overflowing and store the result in {@code dest}.
     * <p>
     * The result is clamped to the {@code byte} range ({@code Byte.MIN_VALUE} to
     * {@code Byte.MAX_VALUE}), not to the destination's, and each result component is then widened
     * to {@code double}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 satSub(byte otherX, byte otherY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = org.joml2.SaturatingMath.satSubB(this.x, otherX);
        d.y = org.joml2.SaturatingMath.satSubB(this.y, otherY);
        return d;
    }

    public byte x() { return this.x; }
    public byte y() { return this.y; }

    public Byte2 xx(@Mutated Byte2 dest) {
        byte _v0 = this.x;
        Byte2Impl d = (Byte2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Byte2 xy(@Mutated Byte2 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte2Impl d = (Byte2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Byte2 yx(@Mutated Byte2 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte2Impl d = (Byte2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Byte2 yy(@Mutated Byte2 dest) {
        byte _v0 = this.y;
        Byte2Impl d = (Byte2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Byte3 xxx(@Mutated Byte3 dest) {
        byte _v0 = this.x;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Byte3 xxy(@Mutated Byte3 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Byte3 xyx(@Mutated Byte3 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Byte3 xyy(@Mutated Byte3 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Byte3 yxx(@Mutated Byte3 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Byte3 yxy(@Mutated Byte3 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Byte3 yyx(@Mutated Byte3 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Byte3 yyy(@Mutated Byte3 dest) {
        byte _v0 = this.y;
        Byte3Impl d = (Byte3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Byte4 xxxx(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Byte4 xxxy(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Byte4 xxyx(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Byte4 xxyy(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Byte4 xyxx(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Byte4 xyxy(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Byte4 xyyx(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Byte4 xyyy(@Mutated Byte4 dest) {
        byte _v0 = this.x;
        byte _v1 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Byte4 yxxx(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Byte4 yxxy(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Byte4 yxyx(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Byte4 yxyy(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Byte4 yyxx(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Byte4 yyxy(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Byte4 yyyx(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        byte _v1 = this.x;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Byte4 yyyy(@Mutated Byte4 dest) {
        byte _v0 = this.y;
        Byte4Impl d = (Byte4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    @Override public String toString() {
        return "Byte2(" + x() + ", " + y() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Byte2Impl)) return false;
        Byte2Impl o = (Byte2Impl) obj;
        return x == o.x
            && y == o.y;
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + x;
        h = 31 * h + y;
        return h;
    }

    @Override public boolean isFinite() {
        return true;
    }

    @Override public boolean equalsEpsilon(Byte2R other, byte epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon;
    }

    public byte[] store(@Mutated byte[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        return dest;
    }
    public @Mutated Byte2 load(byte[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public Byte2 loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public Byte2 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public Byte2 loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public Byte2 load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public short[] store(@Mutated short[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        return dest;
    }
    public @Mutated Byte2 load(short[] src, int offset) {
        this.x = (byte) src[offset + 0];
        this.y = (byte) src[offset + 1];
        return this;
    }
    public ShortBuffer storeAbsolute(int index, @Mutated ShortBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Byte2 loadAbsolute(int index, ShortBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeShortAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeShortAbsolute(this, index, buf);
    }
    public Byte2 loadShortAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadShortAbsolute(this, index, buf);
    }
    public Byte2 storeShortUnsafe(long address) {
        return RAW_OPS.storeShortUnsafe(this, address);
    }
    @Mutated public Byte2 loadShortUnsafe(long address) {
        return RAW_OPS.loadShortUnsafe(this, address);
    }
    public MemorySegment storeShort(long offset, MemorySegment dest) {
        return SEG_OPS.storeShort(this, offset, dest);
    }
    public Byte2 loadShort(long offset, MemorySegment src) {
        return SEG_OPS.loadShort(this, offset, src);
    }

}
