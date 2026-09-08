package org.joml2;

/**
 * Programmatic configuration for the library's global flags, overriding the
 * {@code joml.returnNew}, {@code joml.storeLoadBackend} and {@code joml.vectorApi}
 * system properties.
 *
 * <p>All setters must be called before the first use of any {@code Joml}
 * method or {@code *Ops} class: the class initializers read the overrides once
 * and freeze them into {@code static final} fields (so the JIT can constant-fold
 * them). Calling a setter afterwards throws {@link IllegalStateException}.</p>
 */
public final class JomlConfig {
    private JomlConfig() {}
    static volatile Boolean returnNewOverride;
    static volatile StoreLoadBackend storeLoadBackendOverride;
    static volatile Boolean vectorApiOverride;
    static volatile boolean jomlInitialized;

    /**
     * Set whether the no-dest self-form operations return a freshly allocated
     * instance instead of mutating and returning {@code this} (equivalent to
     * launching with {@code -Djoml.returnNew=true}). Has no effect in the immutable
     * record and value variants, whose operations always return new instances.
     *
     * @param value {@code true} to make self-forms allocate and return new instances
     * @throws IllegalStateException if {@code Joml} has already been initialized
     */
    public static void setReturnNew(boolean value) {
        if (jomlInitialized) throw new IllegalStateException(alreadyInitializedMessage());
        returnNewOverride = value;
    }

    /**
     * Select how the generated store/load methods access native memory
     * (equivalent to launching with {@code -Djoml.storeLoadBackend=...}).
     *
     * @param backend the backend to use
     * @throws IllegalStateException if {@code Joml} has already been initialized
     */
    public static void setStoreLoadBackend(StoreLoadBackend backend) {
        if (jomlInitialized) throw new IllegalStateException(alreadyInitializedMessage());
        storeLoadBackendOverride = backend;
    }

    /**
     * Set whether the {@code *Ops} classes may use their SIMD (Vector-API) kernels
     * (equivalent to launching with {@code -Djoml.vectorApi=...}). {@code false}
     * forces the scalar fallback paths even when {@code jdk.incubator.vector} is
     * present; {@code true} (the default) uses the Vector API when the module is
     * available - it cannot enable SIMD on a JVM without the module. Has no effect
     * in variants that ship scalar {@code *Ops}.
     *
     * @param enabled {@code false} to force the scalar paths
     * @throws IllegalStateException if the flags have already been frozen
     */
    public static void setVectorApi(boolean enabled) {
        if (jomlInitialized) throw new IllegalStateException(alreadyInitializedMessage());
        vectorApiOverride = enabled;
    }

    private static String alreadyInitializedMessage() {
        return "JomlConfig setters must be called before the first use of any Joml method or *Ops class: "
             + "the flags have already been class-initialized into static final fields and are frozen.";
    }
}
