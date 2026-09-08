package org.joml2;

/**
 * Selects how the generated {@code <Type>Ops} read/write individual elements of direct
 * {@link java.nio.Buffer}s and raw {@code long} addresses.
 *
 * <p>The default (when {@code -Djoml.storeLoadBackend} is unset and no
 * {@code JomlConfig} override is given) is {@link #UNSAFE} when {@code sun.misc.Unsafe} /
 * {@code jdk.internal.misc.Unsafe} is available, falling back to {@link #API} otherwise -
 * so the library still initializes on a JDK without {@code Unsafe}.</p>
 */
public enum StoreLoadBackend {
    /**
     * Pure NIO/foreign API: {@code buffer.get(index)} etc. Never touches
     * {@code Unsafe}. Select with {@code -Djoml.storeLoadBackend=api} to opt out of the
     * Unsafe default (e.g. to keep bounds/liveness checks, or avoid {@code sun.misc.Unsafe}).
     */
    API,
    /**
     * {@code sun.misc.Unsafe}/{@code jdk.internal.misc.Unsafe} direct memory access for
     * direct buffers and raw {@code long} addresses (heap and read-only
     * targets still fall to {@link #API}). The default when {@code Unsafe} is available.
     */
    UNSAFE
}
