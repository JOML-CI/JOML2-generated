package org.joml2;

import org.joml2.internal.types.Double3x3Impl;

/**
 * Fixed-size {@link Double3x3} stack - port of JOML 1's
 * {@code Matrix*Stack} for emulating the legacy OpenGL push/pop matrix
 * stack ({@code glPushMatrix} / {@code glPopMatrix}).
 *
 * <p>The current/top matrix IS this object - all inherited
 * {@link Double3x3} operations apply to it directly. Calling
 * {@link #pushMatrix()} snapshots the current state into an internal
 * {@code Double3x3[]} array; {@link #popMatrix()} restores from it.</p>
 *
 * <p>This assumes the default in-place mode: with {@code joml.returnNew} enabled,
 * the inherited self-form operations return fresh instances instead of mutating
 * this stack top, which defeats the push/pop workflow.</p>
 */
public class Double3x3Stack extends Double3x3Impl {

    /** Internal stack of saved matrices. Length is {@code stackSize - 1};
     *  the inherited {@code Double3x3} occupies the implicit top slot. */
    private final Double3x3[] mats;

    /** Index of the next free slot in {@link #mats}. {@code 0} == bottom of stack. */
    private int curr;

    /**
     * Create a new {@link Double3x3Stack} of the given size.
     * The stack pointer starts at zero and the current matrix is the identity.
     *
     * @param stackSize total stack depth, including the implicit top slot ({@code this});
     *                  must be {@code >= 1}
     * @throws IllegalArgumentException if {@code stackSize < 1}
     */
    public Double3x3Stack(int stackSize) {
        if (stackSize < 1)
            throw new IllegalArgumentException("stackSize must be >= 1");
        mats = new Double3x3[stackSize - 1];
        // Eager allocation keeps runtime push/pop allocation-free.
        for (int i = 0; i < mats.length; i++)
            mats[i] = Joml.double3x3();
    }

    /**
     * Increment the stack pointer by one and copy the current matrix into the
     * next saved slot (below the working top), leaving {@code this} as a working
     * copy that can be modified without affecting the saved snapshot.
     *
     * @return this
     * @throws IllegalStateException if the stack is full
     */
    public Double3x3Stack pushMatrix() {
        if (curr == mats.length)
            throw new IllegalStateException("max stack size of " + (curr + 1) + " reached");
        mats[curr++].set(this);
        return this;
    }

    /**
     * Decrement the stack pointer by one and restore the current matrix from the
     * slot directly below the top.
     *
     * @return this
     * @throws IllegalStateException if the stack is already at the bottom
     */
    public Double3x3Stack popMatrix() {
        if (curr == 0)
            throw new IllegalStateException("already at the bottom of the stack");
        set(mats[--curr]);
        return this;
    }

    /**
     * Set the stack pointer to zero and reset the current matrix to identity.
     *
     * @return this
     */
    public Double3x3Stack clear() {
        curr = 0;
        makeIdentity();
        return this;
    }
}
