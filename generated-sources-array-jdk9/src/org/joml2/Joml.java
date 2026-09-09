package org.joml2;

import org.joml2.internal.types.*;
import org.joml2.internal.unsafe.UnsafeOpsHolder;

/**
 * Factory for every generated math type ({@code Joml.float4x4()},
 * {@code Joml.float3(1, 2, 3)}, ...) plus the library's global flags and the
 * matrix property bit masks.
 *
 * <p>The generated implementation classes are not part of the public API;
 * instances are obtained exclusively through these factory methods.</p>
 */
public final class Joml {
    private Joml() {}

    /** Property bit mask: the matrix is known to be affine (last row {@code 0..0 1}). */
    public static final int BIT_AFFINE      = 1;
    /** Property bit mask: the matrix is known to be orthogonal, i.e. its upper-left block is orthonormal with positive determinant (a proper rotation; a reflection is affine, not orthogonal). Includes {@link #BIT_AFFINE}. */
    public static final int BIT_ORTHOGONAL  = 3;
    /** Property bit mask: the matrix is known to be a pure translation. Includes {@link #BIT_ORTHOGONAL} (a pure translation is rigid). */
    public static final int BIT_TRANSLATION = 7;
    /** Property bit mask: the matrix is known to be the identity. Includes all weaker masks' bits. */
    public static final int BIT_IDENTITY    = 15;

    /** The single bit that distinguishes {@link #BIT_AFFINE} from no known properties. */
    public static final int UNIQUE_AFFINE      = 1;
    /** The single bit that distinguishes {@link #BIT_ORTHOGONAL} from the next-weaker mask. */
    public static final int UNIQUE_ORTHOGONAL  = 2;
    /** The single bit that distinguishes {@link #BIT_TRANSLATION} from the next-weaker mask. */
    public static final int UNIQUE_TRANSLATION = 4;
    /** The single bit that distinguishes {@link #BIT_IDENTITY} from the next-weaker mask. */
    public static final int UNIQUE_IDENTITY    = 8;

    /** Whether no-dest self-form operations allocate and return a fresh instance instead of
     *  mutating {@code this}. Resolved once at class initialization from
     *  {@link JomlConfig#setReturnNew} or {@code -Djoml.returnNew}. */
    public static final boolean RETURN_NEW = resolveReturnNew();

    private static boolean resolveReturnNew() {
        try {
            Boolean o = JomlConfig.returnNewOverride;
            return o != null ? o : Boolean.getBoolean("joml.returnNew");
        } finally {
            JomlConfig.jomlInitialized = true;
        }
    }

    /** The store/load backend, resolved once at class initialization from
     *  {@link JomlConfig#setStoreLoadBackend} or {@code -Djoml.storeLoadBackend};
     *  defaults to {@link StoreLoadBackend#UNSAFE} when {@code Unsafe} is available. */
    public static final StoreLoadBackend STORE_LOAD_BACKEND = resolveStoreLoadBackend();

    private static StoreLoadBackend resolveStoreLoadBackend() {
        StoreLoadBackend o = JomlConfig.storeLoadBackendOverride;
        if (o != null) return o;
        String s = System.getProperty("joml.storeLoadBackend");
        if (s != null && s.equalsIgnoreCase("api")) return StoreLoadBackend.API;
        if (s != null && s.equalsIgnoreCase("unsafe")) return StoreLoadBackend.UNSAFE;
        return unsafeAvailable() ? StoreLoadBackend.UNSAFE : StoreLoadBackend.API;
    }

    private static boolean unsafeAvailable() {
        try { return UnsafeOpsHolder.U != null; } catch (Throwable t) { return false; }
    }

    /** Whether the bundled SIMD (Vector-API) kernels of the {@code *Ops} classes are
     *  active: the {@code jdk.incubator.vector} module is present at runtime and not
     *  opted out via {@link JomlConfig#setVectorApi} or {@code -Djoml.vectorApi=false}.
     *  Always {@code false} in variants that ship scalar {@code *Ops}. */
    public static final boolean VECTOR_API = false;

    /** {@return a new {@code Float2}, initialized to all zeros} */
    public static Float2 float2() { return new Float2Impl(); }
    /** {@return a new {@code Float3}, initialized to all zeros} */
    public static Float3 float3() { return new Float3Impl(); }
    /** {@return a new {@code Float4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Float4 float4() { return new Float4Impl(); }
    /** {@return a new {@code Float2x2}, initialized to the identity} */
    public static Float2x2 float2x2() { return new Float2x2Impl(); }
    /** {@return a new {@code Float2x3}, initialized to the identity} */
    public static Float2x3 float2x3() { return new Float2x3Impl(); }
    /** {@return a new {@code Float3x3}, initialized to the identity} */
    public static Float3x3 float3x3() { return new Float3x3Impl(); }
    /** {@return a new {@code Float3x4}, initialized to the identity} */
    public static Float3x4 float3x4() { return new Float3x4Impl(); }
    /** {@return a new {@code Float4x4}, initialized to the identity} */
    public static Float4x4 float4x4() { return new Float4x4Impl(); }
    /** {@return a new {@code Float4x3}, initialized to the identity} */
    public static Float4x3 float4x3() { return new Float4x3Impl(); }
    /** {@return a new {@code Float4x2}, initialized to the identity} */
    public static Float4x2 float4x2() { return new Float4x2Impl(); }
    /** {@return a new {@code Float2x4}, initialized to the identity} */
    public static Float2x4 float2x4() { return new Float2x4Impl(); }
    /** {@return a new {@code Float3x2}, initialized to the identity} */
    public static Float3x2 float3x2() { return new Float3x2Impl(); }
    /** {@return a new {@code FloatQuat}, initialized to the identity} */
    public static FloatQuat floatQuat() { return new FloatQuatImpl(); }
    /** {@return a new {@code FloatDualQuat}, initialized to the identity} */
    public static FloatDualQuat floatDualQuat() { return new FloatDualQuatImpl(); }
    /** {@return a new {@code FloatRect}, initialized to empty inverted bounds (so any union starts from the first added geometry)} */
    public static FloatRect floatRect() { return new FloatRectImpl(); }
    /** {@return a new {@code FloatTransform}, initialized to the identity transform} */
    public static FloatTransform floatTransform() { return new FloatTransformImpl(); }
    /** {@return a new {@code FloatRigid}, initialized to the identity transform} */
    public static FloatRigid floatRigid() { return new FloatRigidImpl(); }
    /** {@return a new {@code FloatOBB}, initialized to a degenerate box with identity orientation and zero center and extents} */
    public static FloatOBB floatOBB() { return new FloatOBBImpl(); }
    /** {@return a new {@code FloatAABB}, initialized to empty inverted bounds (so any union starts from the first added geometry)} */
    public static FloatAABB floatAABB() { return new FloatAABBImpl(); }
    /** {@return a new {@code FloatSphere}, initialized to all zeros} */
    public static FloatSphere floatSphere() { return new FloatSphereImpl(); }
    /** {@return a new {@code FloatRay}, initialized to all zeros} */
    public static FloatRay floatRay() { return new FloatRayImpl(); }
    /** {@return a new {@code FloatPlane}, initialized to all zeros} */
    public static FloatPlane floatPlane() { return new FloatPlaneImpl(); }
    /** {@return a new {@code FloatTriangle}, initialized to all zeros} */
    public static FloatTriangle floatTriangle() { return new FloatTriangleImpl(); }
    /** {@return a new {@code Double2}, initialized to all zeros} */
    public static Double2 double2() { return new Double2Impl(); }
    /** {@return a new {@code Double3}, initialized to all zeros} */
    public static Double3 double3() { return new Double3Impl(); }
    /** {@return a new {@code Double4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Double4 double4() { return new Double4Impl(); }
    /** {@return a new {@code Double2x2}, initialized to the identity} */
    public static Double2x2 double2x2() { return new Double2x2Impl(); }
    /** {@return a new {@code Double2x3}, initialized to the identity} */
    public static Double2x3 double2x3() { return new Double2x3Impl(); }
    /** {@return a new {@code Double3x3}, initialized to the identity} */
    public static Double3x3 double3x3() { return new Double3x3Impl(); }
    /** {@return a new {@code Double3x4}, initialized to the identity} */
    public static Double3x4 double3x4() { return new Double3x4Impl(); }
    /** {@return a new {@code Double4x4}, initialized to the identity} */
    public static Double4x4 double4x4() { return new Double4x4Impl(); }
    /** {@return a new {@code Double4x3}, initialized to the identity} */
    public static Double4x3 double4x3() { return new Double4x3Impl(); }
    /** {@return a new {@code Double4x2}, initialized to the identity} */
    public static Double4x2 double4x2() { return new Double4x2Impl(); }
    /** {@return a new {@code Double2x4}, initialized to the identity} */
    public static Double2x4 double2x4() { return new Double2x4Impl(); }
    /** {@return a new {@code Double3x2}, initialized to the identity} */
    public static Double3x2 double3x2() { return new Double3x2Impl(); }
    /** {@return a new {@code DoubleQuat}, initialized to the identity} */
    public static DoubleQuat doubleQuat() { return new DoubleQuatImpl(); }
    /** {@return a new {@code DoubleDualQuat}, initialized to the identity} */
    public static DoubleDualQuat doubleDualQuat() { return new DoubleDualQuatImpl(); }
    /** {@return a new {@code DoubleRect}, initialized to empty inverted bounds (so any union starts from the first added geometry)} */
    public static DoubleRect doubleRect() { return new DoubleRectImpl(); }
    /** {@return a new {@code DoubleTransform}, initialized to the identity transform} */
    public static DoubleTransform doubleTransform() { return new DoubleTransformImpl(); }
    /** {@return a new {@code DoubleRigid}, initialized to the identity transform} */
    public static DoubleRigid doubleRigid() { return new DoubleRigidImpl(); }
    /** {@return a new {@code DoubleOBB}, initialized to a degenerate box with identity orientation and zero center and extents} */
    public static DoubleOBB doubleOBB() { return new DoubleOBBImpl(); }
    /** {@return a new {@code DoubleAABB}, initialized to empty inverted bounds (so any union starts from the first added geometry)} */
    public static DoubleAABB doubleAABB() { return new DoubleAABBImpl(); }
    /** {@return a new {@code DoubleSphere}, initialized to all zeros} */
    public static DoubleSphere doubleSphere() { return new DoubleSphereImpl(); }
    /** {@return a new {@code DoubleRay}, initialized to all zeros} */
    public static DoubleRay doubleRay() { return new DoubleRayImpl(); }
    /** {@return a new {@code DoublePlane}, initialized to all zeros} */
    public static DoublePlane doublePlane() { return new DoublePlaneImpl(); }
    /** {@return a new {@code DoubleTriangle}, initialized to all zeros} */
    public static DoubleTriangle doubleTriangle() { return new DoubleTriangleImpl(); }
    /** {@return a new {@code Byte2}, initialized to all zeros} */
    public static Byte2 byte2() { return new Byte2Impl(); }
    /** {@return a new {@code Byte3}, initialized to all zeros} */
    public static Byte3 byte3() { return new Byte3Impl(); }
    /** {@return a new {@code Byte4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Byte4 byte4() { return new Byte4Impl(); }
    /** {@return a new {@code Short2}, initialized to all zeros} */
    public static Short2 short2() { return new Short2Impl(); }
    /** {@return a new {@code Short3}, initialized to all zeros} */
    public static Short3 short3() { return new Short3Impl(); }
    /** {@return a new {@code Short4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Short4 short4() { return new Short4Impl(); }
    /** {@return a new {@code Int2}, initialized to all zeros} */
    public static Int2 int2() { return new Int2Impl(); }
    /** {@return a new {@code Int3}, initialized to all zeros} */
    public static Int3 int3() { return new Int3Impl(); }
    /** {@return a new {@code Int4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Int4 int4() { return new Int4Impl(); }
    /** {@return a new {@code IntRect}, initialized to empty inverted bounds (so any union starts from the first added geometry)} */
    public static IntRect intRect() { return new IntRectImpl(); }
    /** {@return a new {@code Long2}, initialized to all zeros} */
    public static Long2 long2() { return new Long2Impl(); }
    /** {@return a new {@code Long3}, initialized to all zeros} */
    public static Long3 long3() { return new Long3Impl(); }
    /** {@return a new {@code Long4}, initialized to the homogeneous default {@code (0, 0, 0, 1)}} */
    public static Long4 long4() { return new Long4Impl(); }

    /** {@return a new {@code Float2} initialized to the given component values} */
    public static Float2 float2(float x, float y) { return float2().set(x, y); }
    /** {@return a new {@code Float3} initialized to the given component values} */
    public static Float3 float3(float x, float y, float z) { return float3().set(x, y, z); }
    /** {@return a new {@code Float4} initialized to the given component values} */
    public static Float4 float4(float x, float y, float z, float w) { return float4().set(x, y, z, w); }
    /** {@return a new {@code Float2x2} initialized to the given component values} */
    public static Float2x2 float2x2(float m00, float m01, float m10, float m11) { return float2x2().set(m00, m01, m10, m11); }
    /** {@return a new {@code Float2x3} initialized to the given component values} */
    public static Float2x3 float2x3(float m00, float m01, float m02, float m10, float m11, float m12) { return float2x3().set(m00, m01, m02, m10, m11, m12); }
    /** {@return a new {@code Float3x3} initialized to the given component values} */
    public static Float3x3 float3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return float3x3().set(m00, m01, m02, m10, m11, m12, m20, m21, m22); }
    /** {@return a new {@code Float3x4} initialized to the given component values} */
    public static Float3x4 float3x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) { return float3x4().set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23); }
    /** {@return a new {@code Float4x4} initialized to the given component values} */
    public static Float4x4 float4x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) { return float4x4().set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33); }
    /** {@return a new {@code Float4x3} initialized to the given component values} */
    public static Float4x3 float4x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, float m30, float m31, float m32) { return float4x3().set(m00, m01, m02, m10, m11, m12, m20, m21, m22, m30, m31, m32); }
    /** {@return a new {@code Float4x2} initialized to the given component values} */
    public static Float4x2 float4x2(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31) { return float4x2().set(m00, m01, m10, m11, m20, m21, m30, m31); }
    /** {@return a new {@code Float2x4} initialized to the given component values} */
    public static Float2x4 float2x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13) { return float2x4().set(m00, m01, m02, m03, m10, m11, m12, m13); }
    /** {@return a new {@code Float3x2} initialized to the given component values} */
    public static Float3x2 float3x2(float m00, float m01, float m10, float m11, float m20, float m21) { return float3x2().set(m00, m01, m10, m11, m20, m21); }
    /** {@return a new {@code FloatQuat} initialized to the given component values} */
    public static FloatQuat floatQuat(float x, float y, float z, float w) { return floatQuat().set(x, y, z, w); }
    /** {@return a new {@code FloatDualQuat} initialized to the given component values} */
    public static FloatDualQuat floatDualQuat(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return floatDualQuat().set(rX, rY, rZ, rW, dX, dY, dZ, dW); }
    /** {@return a new {@code FloatRect} initialized to the given component values} */
    public static FloatRect floatRect(float minX, float minY, float maxX, float maxY) { return floatRect().set(minX, minY, maxX, maxY); }
    /** {@return a new {@code FloatTransform} initialized to the given component values} */
    public static FloatTransform floatTransform(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW, float sX, float sY, float sZ) { return floatTransform().set(tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ); }
    /** {@return a new {@code FloatRigid} initialized to the given component values} */
    public static FloatRigid floatRigid(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) { return floatRigid().set(tX, tY, tZ, rX, rY, rZ, rW); }
    /** {@return a new {@code FloatOBB} initialized to the given component values} */
    public static FloatOBB floatOBB(float cX, float cY, float cZ, float uXx, float uXy, float uXz, float uYx, float uYy, float uYz, float uZx, float uZy, float uZz, float hsX, float hsY, float hsZ) { return floatOBB().set(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ); }
    /** {@return a new {@code FloatAABB} initialized to the given component values} */
    public static FloatAABB floatAABB(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) { return floatAABB().set(minX, minY, minZ, maxX, maxY, maxZ); }
    /** {@return a new {@code FloatSphere} initialized to the given component values} */
    public static FloatSphere floatSphere(float x, float y, float z, float r) { return floatSphere().set(x, y, z, r); }
    /** {@return a new {@code FloatRay} initialized to the given component values} */
    public static FloatRay floatRay(float oX, float oY, float oZ, float dX, float dY, float dZ) { return floatRay().set(oX, oY, oZ, dX, dY, dZ); }
    /** {@return a new {@code FloatPlane} initialized to the given component values} */
    public static FloatPlane floatPlane(float a, float b, float c, float d) { return floatPlane().set(a, b, c, d); }
    /** {@return a new {@code FloatTriangle} initialized to the given component values} */
    public static FloatTriangle floatTriangle(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z) { return floatTriangle().set(v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z); }
    /** {@return a new {@code Double2} initialized to the given component values} */
    public static Double2 double2(double x, double y) { return double2().set(x, y); }
    /** {@return a new {@code Double3} initialized to the given component values} */
    public static Double3 double3(double x, double y, double z) { return double3().set(x, y, z); }
    /** {@return a new {@code Double4} initialized to the given component values} */
    public static Double4 double4(double x, double y, double z, double w) { return double4().set(x, y, z, w); }
    /** {@return a new {@code Double2x2} initialized to the given component values} */
    public static Double2x2 double2x2(double m00, double m01, double m10, double m11) { return double2x2().set(m00, m01, m10, m11); }
    /** {@return a new {@code Double2x3} initialized to the given component values} */
    public static Double2x3 double2x3(double m00, double m01, double m02, double m10, double m11, double m12) { return double2x3().set(m00, m01, m02, m10, m11, m12); }
    /** {@return a new {@code Double3x3} initialized to the given component values} */
    public static Double3x3 double3x3(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) { return double3x3().set(m00, m01, m02, m10, m11, m12, m20, m21, m22); }
    /** {@return a new {@code Double3x4} initialized to the given component values} */
    public static Double3x4 double3x4(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return double3x4().set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23); }
    /** {@return a new {@code Double4x4} initialized to the given component values} */
    public static Double4x4 double4x4(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double m30, double m31, double m32, double m33) { return double4x4().set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33); }
    /** {@return a new {@code Double4x3} initialized to the given component values} */
    public static Double4x3 double4x3(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double m30, double m31, double m32) { return double4x3().set(m00, m01, m02, m10, m11, m12, m20, m21, m22, m30, m31, m32); }
    /** {@return a new {@code Double4x2} initialized to the given component values} */
    public static Double4x2 double4x2(double m00, double m01, double m10, double m11, double m20, double m21, double m30, double m31) { return double4x2().set(m00, m01, m10, m11, m20, m21, m30, m31); }
    /** {@return a new {@code Double2x4} initialized to the given component values} */
    public static Double2x4 double2x4(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13) { return double2x4().set(m00, m01, m02, m03, m10, m11, m12, m13); }
    /** {@return a new {@code Double3x2} initialized to the given component values} */
    public static Double3x2 double3x2(double m00, double m01, double m10, double m11, double m20, double m21) { return double3x2().set(m00, m01, m10, m11, m20, m21); }
    /** {@return a new {@code DoubleQuat} initialized to the given component values} */
    public static DoubleQuat doubleQuat(double x, double y, double z, double w) { return doubleQuat().set(x, y, z, w); }
    /** {@return a new {@code DoubleDualQuat} initialized to the given component values} */
    public static DoubleDualQuat doubleDualQuat(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return doubleDualQuat().set(rX, rY, rZ, rW, dX, dY, dZ, dW); }
    /** {@return a new {@code DoubleRect} initialized to the given component values} */
    public static DoubleRect doubleRect(double minX, double minY, double maxX, double maxY) { return doubleRect().set(minX, minY, maxX, maxY); }
    /** {@return a new {@code DoubleTransform} initialized to the given component values} */
    public static DoubleTransform doubleTransform(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW, double sX, double sY, double sZ) { return doubleTransform().set(tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ); }
    /** {@return a new {@code DoubleRigid} initialized to the given component values} */
    public static DoubleRigid doubleRigid(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW) { return doubleRigid().set(tX, tY, tZ, rX, rY, rZ, rW); }
    /** {@return a new {@code DoubleOBB} initialized to the given component values} */
    public static DoubleOBB doubleOBB(double cX, double cY, double cZ, double uXx, double uXy, double uXz, double uYx, double uYy, double uYz, double uZx, double uZy, double uZz, double hsX, double hsY, double hsZ) { return doubleOBB().set(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ); }
    /** {@return a new {@code DoubleAABB} initialized to the given component values} */
    public static DoubleAABB doubleAABB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) { return doubleAABB().set(minX, minY, minZ, maxX, maxY, maxZ); }
    /** {@return a new {@code DoubleSphere} initialized to the given component values} */
    public static DoubleSphere doubleSphere(double x, double y, double z, double r) { return doubleSphere().set(x, y, z, r); }
    /** {@return a new {@code DoubleRay} initialized to the given component values} */
    public static DoubleRay doubleRay(double oX, double oY, double oZ, double dX, double dY, double dZ) { return doubleRay().set(oX, oY, oZ, dX, dY, dZ); }
    /** {@return a new {@code DoublePlane} initialized to the given component values} */
    public static DoublePlane doublePlane(double a, double b, double c, double d) { return doublePlane().set(a, b, c, d); }
    /** {@return a new {@code DoubleTriangle} initialized to the given component values} */
    public static DoubleTriangle doubleTriangle(double v0X, double v0Y, double v0Z, double v1X, double v1Y, double v1Z, double v2X, double v2Y, double v2Z) { return doubleTriangle().set(v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z); }
    /** {@return a new {@code Byte2} initialized to the given component values} */
    public static Byte2 byte2(byte x, byte y) { return byte2().set(x, y); }
    /** {@return a new {@code Byte3} initialized to the given component values} */
    public static Byte3 byte3(byte x, byte y, byte z) { return byte3().set(x, y, z); }
    /** {@return a new {@code Byte4} initialized to the given component values} */
    public static Byte4 byte4(byte x, byte y, byte z, byte w) { return byte4().set(x, y, z, w); }
    /** {@return a new {@code Short2} initialized to the given component values} */
    public static Short2 short2(short x, short y) { return short2().set(x, y); }
    /** {@return a new {@code Short3} initialized to the given component values} */
    public static Short3 short3(short x, short y, short z) { return short3().set(x, y, z); }
    /** {@return a new {@code Short4} initialized to the given component values} */
    public static Short4 short4(short x, short y, short z, short w) { return short4().set(x, y, z, w); }
    /** {@return a new {@code Int2} initialized to the given component values} */
    public static Int2 int2(int x, int y) { return int2().set(x, y); }
    /** {@return a new {@code Int3} initialized to the given component values} */
    public static Int3 int3(int x, int y, int z) { return int3().set(x, y, z); }
    /** {@return a new {@code Int4} initialized to the given component values} */
    public static Int4 int4(int x, int y, int z, int w) { return int4().set(x, y, z, w); }
    /** {@return a new {@code IntRect} initialized to the given component values} */
    public static IntRect intRect(int minX, int minY, int maxX, int maxY) { return intRect().set(minX, minY, maxX, maxY); }
    /** {@return a new {@code Long2} initialized to the given component values} */
    public static Long2 long2(long x, long y) { return long2().set(x, y); }
    /** {@return a new {@code Long3} initialized to the given component values} */
    public static Long3 long3(long x, long y, long z) { return long3().set(x, y, z); }
    /** {@return a new {@code Long4} initialized to the given component values} */
    public static Long4 long4(long x, long y, long z, long w) { return long4().set(x, y, z, w); }

    /** {@return a new {@code Float2} with all components set to {@code s}} */
    public static Float2 float2(float s) { return float2().set(s); }
    /** {@return a new {@code Float3} with all components set to {@code s}} */
    public static Float3 float3(float s) { return float3().set(s); }
    /** {@return a new {@code Float4} with all components set to {@code s}} */
    public static Float4 float4(float s) { return float4().set(s); }
    /** {@return a new {@code Double2} with all components set to {@code s}} */
    public static Double2 double2(double s) { return double2().set(s); }
    /** {@return a new {@code Double3} with all components set to {@code s}} */
    public static Double3 double3(double s) { return double3().set(s); }
    /** {@return a new {@code Double4} with all components set to {@code s}} */
    public static Double4 double4(double s) { return double4().set(s); }
    /** {@return a new {@code Byte2} with all components set to {@code s}} */
    public static Byte2 byte2(byte s) { return byte2().set(s); }
    /** {@return a new {@code Byte3} with all components set to {@code s}} */
    public static Byte3 byte3(byte s) { return byte3().set(s); }
    /** {@return a new {@code Byte4} with all components set to {@code s}} */
    public static Byte4 byte4(byte s) { return byte4().set(s); }
    /** {@return a new {@code Short2} with all components set to {@code s}} */
    public static Short2 short2(short s) { return short2().set(s); }
    /** {@return a new {@code Short3} with all components set to {@code s}} */
    public static Short3 short3(short s) { return short3().set(s); }
    /** {@return a new {@code Short4} with all components set to {@code s}} */
    public static Short4 short4(short s) { return short4().set(s); }
    /** {@return a new {@code Int2} with all components set to {@code s}} */
    public static Int2 int2(int s) { return int2().set(s); }
    /** {@return a new {@code Int3} with all components set to {@code s}} */
    public static Int3 int3(int s) { return int3().set(s); }
    /** {@return a new {@code Int4} with all components set to {@code s}} */
    public static Int4 int4(int s) { return int4().set(s); }
    /** {@return a new {@code Long2} with all components set to {@code s}} */
    public static Long2 long2(long s) { return long2().set(s); }
    /** {@return a new {@code Long3} with all components set to {@code s}} */
    public static Long3 long3(long s) { return long3().set(s); }
    /** {@return a new {@code Long4} with all components set to {@code s}} */
    public static Long4 long4(long s) { return long4().set(s); }

    /** {@return a new {@code Float3} composed of the given parts, in order} */
    public static Float3 float3(float v0, Float2R v1) { return float3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Float3} composed of the given parts, in order} */
    public static Float3 float3(Float2R v0, float v1) { return float3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(float v0, float v1, Float2R v2) { return float4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(float v0, Float2R v1, float v2) { return float4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(float v0, Float3R v1) { return float4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(Float2R v0, float v1, float v2) { return float4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(Float2R v0, Float2R v1) { return float4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Float4} composed of the given parts, in order} */
    public static Float4 float4(Float3R v0, float v1) { return float4().set(v0.x(), v0.y(), v0.z(), v1); }
    /** {@return a new {@code Double3} composed of the given parts, in order} */
    public static Double3 double3(double v0, Double2R v1) { return double3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Double3} composed of the given parts, in order} */
    public static Double3 double3(Double2R v0, double v1) { return double3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(double v0, double v1, Double2R v2) { return double4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(double v0, Double2R v1, double v2) { return double4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(double v0, Double3R v1) { return double4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(Double2R v0, double v1, double v2) { return double4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(Double2R v0, Double2R v1) { return double4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Double4} composed of the given parts, in order} */
    public static Double4 double4(Double3R v0, double v1) { return double4().set(v0.x(), v0.y(), v0.z(), v1); }
    /** {@return a new {@code Byte3} composed of the given parts, in order} */
    public static Byte3 byte3(byte v0, Byte2R v1) { return byte3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Byte3} composed of the given parts, in order} */
    public static Byte3 byte3(Byte2R v0, byte v1) { return byte3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(byte v0, byte v1, Byte2R v2) { return byte4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(byte v0, Byte2R v1, byte v2) { return byte4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(byte v0, Byte3R v1) { return byte4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(Byte2R v0, byte v1, byte v2) { return byte4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(Byte2R v0, Byte2R v1) { return byte4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Byte4} composed of the given parts, in order} */
    public static Byte4 byte4(Byte3R v0, byte v1) { return byte4().set(v0.x(), v0.y(), v0.z(), v1); }
    /** {@return a new {@code Short3} composed of the given parts, in order} */
    public static Short3 short3(short v0, Short2R v1) { return short3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Short3} composed of the given parts, in order} */
    public static Short3 short3(Short2R v0, short v1) { return short3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(short v0, short v1, Short2R v2) { return short4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(short v0, Short2R v1, short v2) { return short4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(short v0, Short3R v1) { return short4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(Short2R v0, short v1, short v2) { return short4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(Short2R v0, Short2R v1) { return short4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Short4} composed of the given parts, in order} */
    public static Short4 short4(Short3R v0, short v1) { return short4().set(v0.x(), v0.y(), v0.z(), v1); }
    /** {@return a new {@code Int3} composed of the given parts, in order} */
    public static Int3 int3(int v0, Int2R v1) { return int3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Int3} composed of the given parts, in order} */
    public static Int3 int3(Int2R v0, int v1) { return int3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(int v0, int v1, Int2R v2) { return int4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(int v0, Int2R v1, int v2) { return int4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(int v0, Int3R v1) { return int4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(Int2R v0, int v1, int v2) { return int4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(Int2R v0, Int2R v1) { return int4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Int4} composed of the given parts, in order} */
    public static Int4 int4(Int3R v0, int v1) { return int4().set(v0.x(), v0.y(), v0.z(), v1); }
    /** {@return a new {@code Long3} composed of the given parts, in order} */
    public static Long3 long3(long v0, Long2R v1) { return long3().set(v0, v1.x(), v1.y()); }
    /** {@return a new {@code Long3} composed of the given parts, in order} */
    public static Long3 long3(Long2R v0, long v1) { return long3().set(v0.x(), v0.y(), v1); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(long v0, long v1, Long2R v2) { return long4().set(v0, v1, v2.x(), v2.y()); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(long v0, Long2R v1, long v2) { return long4().set(v0, v1.x(), v1.y(), v2); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(long v0, Long3R v1) { return long4().set(v0, v1.x(), v1.y(), v1.z()); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(Long2R v0, long v1, long v2) { return long4().set(v0.x(), v0.y(), v1, v2); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(Long2R v0, Long2R v1) { return long4().set(v0.x(), v0.y(), v1.x(), v1.y()); }
    /** {@return a new {@code Long4} composed of the given parts, in order} */
    public static Long4 long4(Long3R v0, long v1) { return long4().set(v0.x(), v0.y(), v0.z(), v1); }

    /** {@return a new {@code Float2x2} built from the given column vectors} */
    public static Float2x2 float2x2(Float2R c0, Float2R c1) { return float2x2().set(c0.x(), c1.x(), c0.y(), c1.y()); }
    /** {@return a new {@code Float2x3} built from the given column vectors} */
    public static Float2x3 float2x3(Float2R c0, Float2R c1, Float2R c2) { return float2x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y()); }
    /** {@return a new {@code Float3x3} built from the given column vectors} */
    public static Float3x3 float3x3(Float3R c0, Float3R c1, Float3R c2) { return float3x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z()); }
    /** {@return a new {@code Float3x4} built from the given column vectors} */
    public static Float3x4 float3x4(Float3R c0, Float3R c1, Float3R c2, Float3R c3) { return float3x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z()); }
    /** {@return a new {@code Float4x4} built from the given column vectors} */
    public static Float4x4 float4x4(Float4R c0, Float4R c1, Float4R c2, Float4R c3) { return float4x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z(), c0.w(), c1.w(), c2.w(), c3.w()); }
    /** {@return a new {@code Float4x3} built from the given column vectors} */
    public static Float4x3 float4x3(Float4R c0, Float4R c1, Float4R c2) { return float4x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z(), c0.w(), c1.w(), c2.w()); }
    /** {@return a new {@code Float4x2} built from the given column vectors} */
    public static Float4x2 float4x2(Float4R c0, Float4R c1) { return float4x2().set(c0.x(), c1.x(), c0.y(), c1.y(), c0.z(), c1.z(), c0.w(), c1.w()); }
    /** {@return a new {@code Float2x4} built from the given column vectors} */
    public static Float2x4 float2x4(Float2R c0, Float2R c1, Float2R c2, Float2R c3) { return float2x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y()); }
    /** {@return a new {@code Float3x2} built from the given column vectors} */
    public static Float3x2 float3x2(Float3R c0, Float3R c1) { return float3x2().set(c0.x(), c1.x(), c0.y(), c1.y(), c0.z(), c1.z()); }
    /** {@return a new {@code Double2x2} built from the given column vectors} */
    public static Double2x2 double2x2(Double2R c0, Double2R c1) { return double2x2().set(c0.x(), c1.x(), c0.y(), c1.y()); }
    /** {@return a new {@code Double2x3} built from the given column vectors} */
    public static Double2x3 double2x3(Double2R c0, Double2R c1, Double2R c2) { return double2x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y()); }
    /** {@return a new {@code Double3x3} built from the given column vectors} */
    public static Double3x3 double3x3(Double3R c0, Double3R c1, Double3R c2) { return double3x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z()); }
    /** {@return a new {@code Double3x4} built from the given column vectors} */
    public static Double3x4 double3x4(Double3R c0, Double3R c1, Double3R c2, Double3R c3) { return double3x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z()); }
    /** {@return a new {@code Double4x4} built from the given column vectors} */
    public static Double4x4 double4x4(Double4R c0, Double4R c1, Double4R c2, Double4R c3) { return double4x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z(), c0.w(), c1.w(), c2.w(), c3.w()); }
    /** {@return a new {@code Double4x3} built from the given column vectors} */
    public static Double4x3 double4x3(Double4R c0, Double4R c1, Double4R c2) { return double4x3().set(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z(), c0.w(), c1.w(), c2.w()); }
    /** {@return a new {@code Double4x2} built from the given column vectors} */
    public static Double4x2 double4x2(Double4R c0, Double4R c1) { return double4x2().set(c0.x(), c1.x(), c0.y(), c1.y(), c0.z(), c1.z(), c0.w(), c1.w()); }
    /** {@return a new {@code Double2x4} built from the given column vectors} */
    public static Double2x4 double2x4(Double2R c0, Double2R c1, Double2R c2, Double2R c3) { return double2x4().set(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y()); }
    /** {@return a new {@code Double3x2} built from the given column vectors} */
    public static Double3x2 double3x2(Double3R c0, Double3R c1) { return double3x2().set(c0.x(), c1.x(), c0.y(), c1.y(), c0.z(), c1.z()); }

    /** {@return a new {@code Float2x2} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float2x2 float2x2(Float2x3R src) { return float2x2().set(src.m00(), src.m01(), src.m10(), src.m11()); }
    /** {@return a new {@code Float2x2} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float2x2 float2x2(Float3x3R src) { return float2x2().set(src.m00(), src.m01(), src.m10(), src.m11()); }
    /** {@return a new {@code Float2x3} initialized to {@code src}, identity-extended with a zero translation column} */
    public static Float2x3 float2x3(Float2x2R src) { return float2x3().set(src.m00(), src.m01(), 0, src.m10(), src.m11(), 0); }
    /** {@return a new {@code Float2x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float2x3 float2x3(Float3x3R src) { return float2x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12()); }
    /** {@return a new {@code Float3x3} initialized to {@code src}, identity-extended to the full square shape} */
    public static Float3x3 float3x3(Float2x3R src) { return float3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), 0, 0, 1); }
    /** {@return a new {@code Float3x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float3x3 float3x3(Float4x4R src) { return float3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22()); }
    /** {@return a new {@code Float3x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float3x3 float3x3(Float3x4R src) { return float3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22()); }
    /** {@return a new {@code Float3x3} initialized to {@code src}, identity-extended to the full square shape} */
    public static Float3x3 float3x3(Float2x2R src) { return float3x3().set(src.m00(), src.m01(), 0, src.m10(), src.m11(), 0, 0, 0, 1); }
    /** {@return a new {@code Float3x4} initialized to {@code src}, identity-extended with a zero translation column} */
    public static Float3x4 float3x4(Float3x3R src) { return float3x4().set(src.m00(), src.m01(), src.m02(), 0, src.m10(), src.m11(), src.m12(), 0, src.m20(), src.m21(), src.m22(), 0); }
    /** {@return a new {@code Float3x4} initialized to {@code src}, truncated to the overlapping cells} */
    public static Float3x4 float3x4(Float4x4R src) { return float3x4().set(src.m00(), src.m01(), src.m02(), src.m03(), src.m10(), src.m11(), src.m12(), src.m13(), src.m20(), src.m21(), src.m22(), src.m23()); }
    /** {@return a new {@code Float4x4} initialized to {@code src}, identity-extended to the full square shape} */
    public static Float4x4 float4x4(Float3x4R src) { return float4x4().set(src.m00(), src.m01(), src.m02(), src.m03(), src.m10(), src.m11(), src.m12(), src.m13(), src.m20(), src.m21(), src.m22(), src.m23(), 0, 0, 0, 1); }
    /** {@return a new {@code Float4x4} initialized to {@code src}, identity-extended to the full square shape} */
    public static Float4x4 float4x4(Float3x3R src) { return float4x4().set(src.m00(), src.m01(), src.m02(), 0, src.m10(), src.m11(), src.m12(), 0, src.m20(), src.m21(), src.m22(), 0, 0, 0, 0, 1); }
    /** {@return a new {@code Double2x2} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double2x2 double2x2(Double2x3R src) { return double2x2().set(src.m00(), src.m01(), src.m10(), src.m11()); }
    /** {@return a new {@code Double2x2} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double2x2 double2x2(Double3x3R src) { return double2x2().set(src.m00(), src.m01(), src.m10(), src.m11()); }
    /** {@return a new {@code Double2x3} initialized to {@code src}, identity-extended with a zero translation column} */
    public static Double2x3 double2x3(Double2x2R src) { return double2x3().set(src.m00(), src.m01(), 0, src.m10(), src.m11(), 0); }
    /** {@return a new {@code Double2x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double2x3 double2x3(Double3x3R src) { return double2x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12()); }
    /** {@return a new {@code Double3x3} initialized to {@code src}, identity-extended to the full square shape} */
    public static Double3x3 double3x3(Double2x3R src) { return double3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), 0, 0, 1); }
    /** {@return a new {@code Double3x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double3x3 double3x3(Double4x4R src) { return double3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22()); }
    /** {@return a new {@code Double3x3} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double3x3 double3x3(Double3x4R src) { return double3x3().set(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22()); }
    /** {@return a new {@code Double3x3} initialized to {@code src}, identity-extended to the full square shape} */
    public static Double3x3 double3x3(Double2x2R src) { return double3x3().set(src.m00(), src.m01(), 0, src.m10(), src.m11(), 0, 0, 0, 1); }
    /** {@return a new {@code Double3x4} initialized to {@code src}, identity-extended with a zero translation column} */
    public static Double3x4 double3x4(Double3x3R src) { return double3x4().set(src.m00(), src.m01(), src.m02(), 0, src.m10(), src.m11(), src.m12(), 0, src.m20(), src.m21(), src.m22(), 0); }
    /** {@return a new {@code Double3x4} initialized to {@code src}, truncated to the overlapping cells} */
    public static Double3x4 double3x4(Double4x4R src) { return double3x4().set(src.m00(), src.m01(), src.m02(), src.m03(), src.m10(), src.m11(), src.m12(), src.m13(), src.m20(), src.m21(), src.m22(), src.m23()); }
    /** {@return a new {@code Double4x4} initialized to {@code src}, identity-extended to the full square shape} */
    public static Double4x4 double4x4(Double3x4R src) { return double4x4().set(src.m00(), src.m01(), src.m02(), src.m03(), src.m10(), src.m11(), src.m12(), src.m13(), src.m20(), src.m21(), src.m22(), src.m23(), 0, 0, 0, 1); }
    /** {@return a new {@code Double4x4} initialized to {@code src}, identity-extended to the full square shape} */
    public static Double4x4 double4x4(Double3x3R src) { return double4x4().set(src.m00(), src.m01(), src.m02(), 0, src.m10(), src.m11(), src.m12(), 0, src.m20(), src.m21(), src.m22(), 0, 0, 0, 0, 1); }

    /** {@return a new {@code Float2} initialized to a copy of {@code src}} */
    public static Float2 float2(Float2R src) { return float2().set(src); }
    /** {@return a new {@code Float3} initialized to a copy of {@code src}} */
    public static Float3 float3(Float3R src) { return float3().set(src); }
    /** {@return a new {@code Float4} initialized to a copy of {@code src}} */
    public static Float4 float4(Float4R src) { return float4().set(src); }
    /** {@return a new {@code Float2x2} initialized to a copy of {@code src}} */
    public static Float2x2 float2x2(Float2x2R src) { return float2x2().set(src); }
    /** {@return a new {@code Float2x3} initialized to a copy of {@code src}} */
    public static Float2x3 float2x3(Float2x3R src) { return float2x3().set(src); }
    /** {@return a new {@code Float3x3} initialized to a copy of {@code src}} */
    public static Float3x3 float3x3(Float3x3R src) { return float3x3().set(src); }
    /** {@return a new {@code Float3x4} initialized to a copy of {@code src}} */
    public static Float3x4 float3x4(Float3x4R src) { return float3x4().set(src); }
    /** {@return a new {@code Float4x4} initialized to a copy of {@code src}} */
    public static Float4x4 float4x4(Float4x4R src) { return float4x4().set(src); }
    /** {@return a new {@code Float4x3} initialized to a copy of {@code src}} */
    public static Float4x3 float4x3(Float4x3R src) { return float4x3().set(src); }
    /** {@return a new {@code Float4x2} initialized to a copy of {@code src}} */
    public static Float4x2 float4x2(Float4x2R src) { return float4x2().set(src); }
    /** {@return a new {@code Float2x4} initialized to a copy of {@code src}} */
    public static Float2x4 float2x4(Float2x4R src) { return float2x4().set(src); }
    /** {@return a new {@code Float3x2} initialized to a copy of {@code src}} */
    public static Float3x2 float3x2(Float3x2R src) { return float3x2().set(src); }
    /** {@return a new {@code FloatQuat} initialized to a copy of {@code src}} */
    public static FloatQuat floatQuat(FloatQuatR src) { return floatQuat().set(src); }
    /** {@return a new {@code FloatDualQuat} initialized to a copy of {@code src}} */
    public static FloatDualQuat floatDualQuat(FloatDualQuatR src) { return floatDualQuat().set(src); }
    /** {@return a new {@code FloatRect} initialized to a copy of {@code src}} */
    public static FloatRect floatRect(FloatRectR src) { return floatRect().set(src); }
    /** {@return a new {@code FloatTransform} initialized to a copy of {@code src}} */
    public static FloatTransform floatTransform(FloatTransformR src) { return floatTransform().set(src); }
    /** {@return a new {@code FloatRigid} initialized to a copy of {@code src}} */
    public static FloatRigid floatRigid(FloatRigidR src) { return floatRigid().set(src); }
    /** {@return a new {@code FloatOBB} initialized to a copy of {@code src}} */
    public static FloatOBB floatOBB(FloatOBBR src) { return floatOBB().set(src); }
    /** {@return a new {@code FloatAABB} initialized to a copy of {@code src}} */
    public static FloatAABB floatAABB(FloatAABBR src) { return floatAABB().set(src); }
    /** {@return a new {@code FloatSphere} initialized to a copy of {@code src}} */
    public static FloatSphere floatSphere(FloatSphereR src) { return floatSphere().set(src); }
    /** {@return a new {@code FloatRay} initialized to a copy of {@code src}} */
    public static FloatRay floatRay(FloatRayR src) { return floatRay().set(src); }
    /** {@return a new {@code FloatPlane} initialized to a copy of {@code src}} */
    public static FloatPlane floatPlane(FloatPlaneR src) { return floatPlane().set(src); }
    /** {@return a new {@code FloatTriangle} initialized to a copy of {@code src}} */
    public static FloatTriangle floatTriangle(FloatTriangleR src) { return floatTriangle().set(src); }
    /** {@return a new {@code Double2} initialized to a copy of {@code src}} */
    public static Double2 double2(Double2R src) { return double2().set(src); }
    /** {@return a new {@code Double3} initialized to a copy of {@code src}} */
    public static Double3 double3(Double3R src) { return double3().set(src); }
    /** {@return a new {@code Double4} initialized to a copy of {@code src}} */
    public static Double4 double4(Double4R src) { return double4().set(src); }
    /** {@return a new {@code Double2x2} initialized to a copy of {@code src}} */
    public static Double2x2 double2x2(Double2x2R src) { return double2x2().set(src); }
    /** {@return a new {@code Double2x3} initialized to a copy of {@code src}} */
    public static Double2x3 double2x3(Double2x3R src) { return double2x3().set(src); }
    /** {@return a new {@code Double3x3} initialized to a copy of {@code src}} */
    public static Double3x3 double3x3(Double3x3R src) { return double3x3().set(src); }
    /** {@return a new {@code Double3x4} initialized to a copy of {@code src}} */
    public static Double3x4 double3x4(Double3x4R src) { return double3x4().set(src); }
    /** {@return a new {@code Double4x4} initialized to a copy of {@code src}} */
    public static Double4x4 double4x4(Double4x4R src) { return double4x4().set(src); }
    /** {@return a new {@code Double4x3} initialized to a copy of {@code src}} */
    public static Double4x3 double4x3(Double4x3R src) { return double4x3().set(src); }
    /** {@return a new {@code Double4x2} initialized to a copy of {@code src}} */
    public static Double4x2 double4x2(Double4x2R src) { return double4x2().set(src); }
    /** {@return a new {@code Double2x4} initialized to a copy of {@code src}} */
    public static Double2x4 double2x4(Double2x4R src) { return double2x4().set(src); }
    /** {@return a new {@code Double3x2} initialized to a copy of {@code src}} */
    public static Double3x2 double3x2(Double3x2R src) { return double3x2().set(src); }
    /** {@return a new {@code DoubleQuat} initialized to a copy of {@code src}} */
    public static DoubleQuat doubleQuat(DoubleQuatR src) { return doubleQuat().set(src); }
    /** {@return a new {@code DoubleDualQuat} initialized to a copy of {@code src}} */
    public static DoubleDualQuat doubleDualQuat(DoubleDualQuatR src) { return doubleDualQuat().set(src); }
    /** {@return a new {@code DoubleRect} initialized to a copy of {@code src}} */
    public static DoubleRect doubleRect(DoubleRectR src) { return doubleRect().set(src); }
    /** {@return a new {@code DoubleTransform} initialized to a copy of {@code src}} */
    public static DoubleTransform doubleTransform(DoubleTransformR src) { return doubleTransform().set(src); }
    /** {@return a new {@code DoubleRigid} initialized to a copy of {@code src}} */
    public static DoubleRigid doubleRigid(DoubleRigidR src) { return doubleRigid().set(src); }
    /** {@return a new {@code DoubleOBB} initialized to a copy of {@code src}} */
    public static DoubleOBB doubleOBB(DoubleOBBR src) { return doubleOBB().set(src); }
    /** {@return a new {@code DoubleAABB} initialized to a copy of {@code src}} */
    public static DoubleAABB doubleAABB(DoubleAABBR src) { return doubleAABB().set(src); }
    /** {@return a new {@code DoubleSphere} initialized to a copy of {@code src}} */
    public static DoubleSphere doubleSphere(DoubleSphereR src) { return doubleSphere().set(src); }
    /** {@return a new {@code DoubleRay} initialized to a copy of {@code src}} */
    public static DoubleRay doubleRay(DoubleRayR src) { return doubleRay().set(src); }
    /** {@return a new {@code DoublePlane} initialized to a copy of {@code src}} */
    public static DoublePlane doublePlane(DoublePlaneR src) { return doublePlane().set(src); }
    /** {@return a new {@code DoubleTriangle} initialized to a copy of {@code src}} */
    public static DoubleTriangle doubleTriangle(DoubleTriangleR src) { return doubleTriangle().set(src); }
    /** {@return a new {@code Byte2} initialized to a copy of {@code src}} */
    public static Byte2 byte2(Byte2R src) { return byte2().set(src); }
    /** {@return a new {@code Byte3} initialized to a copy of {@code src}} */
    public static Byte3 byte3(Byte3R src) { return byte3().set(src); }
    /** {@return a new {@code Byte4} initialized to a copy of {@code src}} */
    public static Byte4 byte4(Byte4R src) { return byte4().set(src); }
    /** {@return a new {@code Short2} initialized to a copy of {@code src}} */
    public static Short2 short2(Short2R src) { return short2().set(src); }
    /** {@return a new {@code Short3} initialized to a copy of {@code src}} */
    public static Short3 short3(Short3R src) { return short3().set(src); }
    /** {@return a new {@code Short4} initialized to a copy of {@code src}} */
    public static Short4 short4(Short4R src) { return short4().set(src); }
    /** {@return a new {@code Int2} initialized to a copy of {@code src}} */
    public static Int2 int2(Int2R src) { return int2().set(src); }
    /** {@return a new {@code Int3} initialized to a copy of {@code src}} */
    public static Int3 int3(Int3R src) { return int3().set(src); }
    /** {@return a new {@code Int4} initialized to a copy of {@code src}} */
    public static Int4 int4(Int4R src) { return int4().set(src); }
    /** {@return a new {@code IntRect} initialized to a copy of {@code src}} */
    public static IntRect intRect(IntRectR src) { return intRect().set(src); }
    /** {@return a new {@code Long2} initialized to a copy of {@code src}} */
    public static Long2 long2(Long2R src) { return long2().set(src); }
    /** {@return a new {@code Long3} initialized to a copy of {@code src}} */
    public static Long3 long3(Long3R src) { return long3().set(src); }
    /** {@return a new {@code Long4} initialized to a copy of {@code src}} */
    public static Long4 long4(Long4R src) { return long4().set(src); }
}
