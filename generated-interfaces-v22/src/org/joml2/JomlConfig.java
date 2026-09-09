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
 *
 * <p>Accepted system-property spellings:</p>
 * <ul>
 *   <li>{@code -Djoml.returnNew=true} / {@code =false} (case-insensitive); a bare
 *       {@code -Djoml.returnNew} (present, empty value) means {@code true}, like
 *       {@code -Djoml.strictMath}. Any other value means {@code false}.</li>
 *   <li>{@code -Djoml.storeLoadBackend=api} / {@code =unsafe} (case-insensitive,
 *       surrounding whitespace ignored). Unset or empty selects the default (UNSAFE when
 *       {@code sun.misc.Unsafe} is available, else API). {@code unsafe} on a JVM without
 *       {@code sun.misc.Unsafe} logs one warning on {@code System.err} and uses API; an
 *       unrecognised value logs one warning and uses the default.</li>
 *   <li>{@code -Djoml.vectorApi=false} disables the SIMD kernels; any other value (or unset)
 *       leaves them enabled when {@code jdk.incubator.vector} is present.</li>
 * </ul>
 *
 * <p>{@code returnNew} changes only the computing self-form operations ({@code v.add(o)},
 * {@code m.mul(n)}, {@code q.normalize()}, ...): they leave {@code this} unchanged and return
 * a new instance holding the result. The {@code set*}, {@code make*}, {@code load*} and
 * {@code composeTRS*} methods are setters, not computations, and still mutate and return
 * {@code this}.</p>
 *
 * <p>The UNSAFE store/load backend uses {@code sun.misc.Unsafe}; on JDK 23+ (JEP 471) run with
 * {@code --sun-misc-unsafe-memory-access=allow} or select {@code -Djoml.storeLoadBackend=api}.</p>
 */
public final class JomlConfig {
    private JomlConfig() {}
    static volatile Boolean returnNewOverride;
    static volatile StoreLoadBackend storeLoadBackendOverride;
    static volatile Boolean vectorApiOverride;
    static volatile boolean jomlInitialized;

    /**
     * Set whether the computing no-dest self-form operations ({@code v.add(o)},
     * {@code m.mul(n)}, {@code q.normalize()}, ...) return a freshly allocated
     * instance instead of mutating and returning {@code this} (equivalent to
     * launching with {@code -Djoml.returnNew=true}). The {@code set*}, {@code make*},
     * {@code load*} and {@code composeTRS*} methods are setters and always mutate
     * {@code this}. Has no effect in the immutable
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
     * {@link StoreLoadBackend#UNSAFE} on a JVM without {@code sun.misc.Unsafe} logs
     * one warning on {@code System.err} and resolves to {@link StoreLoadBackend#API}.
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
