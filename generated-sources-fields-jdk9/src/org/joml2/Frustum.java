package org.joml2;

/**
 * The six clip planes of a view-projection matrix, for view-frustum culling.
 * <p>
 * {@link #set(Float4x4R, boolean, boolean)} - and the equivalent constructors -
 * extracts the planes from a matrix. They live in the space that matrix maps
 * <em>from</em>: pass a projection matrix to cull in view space, a view-projection
 * matrix to cull in world space, or a model-view-projection matrix to cull in model
 * space. Every plane normal points <em>into</em> the frustum, so a point is inside
 * exactly when its signed distance from all six planes is non-negative.
 * <p>
 * The planes are named by {@link FrustumPlane}: the {@code cullingPlane} family
 * returns one to name the plane that culled a box (or <code>null</code> when nothing
 * culled it),
 * {@link #distanceToPlane(float, float, float, float, float, float, FrustumPlane)}
 * takes one, and the <code>PLANE_MASK_*</code> constants are the matching bits of the
 * {@code mask} argument, which selects the planes to test.
 * <p>
 * The plane coefficients are unit length only when the frustum was built with
 * <code>allowTestSpheres = true</code>. The sphere tests and
 * {@link #distanceToPlane(float, float, float, float, float, float, FrustumPlane)}
 * need that normalization to be metric; the point, box, rectangle and line-segment
 * tests give the same verdicts either way.
 * <p>
 * The sphere, box and rectangle tests are <em>conservative</em>: each asks only
 * whether the volume lies completely outside one single plane, so a volume in a
 * corner region - outside the frustum, yet outside no single plane - is reported as
 * intersecting. They never report a false negative, which is what culling needs.
 * {@link #testPoint(float, float, float)} and
 * {@link #testLineSegment(float, float, float, float, float, float)} are exact.
 * <p>
 * A frustum is mutable and not thread-safe: {@link #set(Float4x4R)} overwrites the
 * planes in place.
 */
public class Frustum {

    /**
     * How a volume relates to the frustum.
     * <p>
     * {@link #INSIDE} is exact for boxes and spheres alike. {@link #INTERSECT} is
     * conservative: a volume lying in a corner region outside the frustum - outside
     * the frustum, yet outside no single plane - is reported as intersecting rather
     * than {@link #OUTSIDE}. The error never goes the other way, which is what
     * culling needs.
     */
    public enum Intersection {
        /** The volume lies completely inside the frustum. */
        INSIDE,
        /** The volume crosses at least one plane. */
        INTERSECT,
        /** The volume lies completely outside at least one plane. */
        OUTSIDE
    }

    /** {@code mask} bit selecting the left (-X) plane. */
    public static final int PLANE_MASK_NX = 1 << FrustumPlane.NX.ordinal();
    /** {@code mask} bit selecting the right (+X) plane. */
    public static final int PLANE_MASK_PX = 1 << FrustumPlane.PX.ordinal();
    /** {@code mask} bit selecting the bottom (-Y) plane. */
    public static final int PLANE_MASK_NY = 1 << FrustumPlane.NY.ordinal();
    /** {@code mask} bit selecting the top (+Y) plane. */
    public static final int PLANE_MASK_PY = 1 << FrustumPlane.PY.ordinal();
    /** {@code mask} bit selecting the near (-Z) plane. */
    public static final int PLANE_MASK_NZ = 1 << FrustumPlane.NZ.ordinal();
    /** {@code mask} bit selecting the far (+Z) plane. */
    public static final int PLANE_MASK_PZ = 1 << FrustumPlane.PZ.ordinal();

    private float nxX, nxY, nxZ, nxW;
    private float pxX, pxY, pxZ, pxW;
    private float nyX, nyY, nyZ, nyW;
    private float pyX, pyY, pyZ, pyW;
    private float nzX, nzY, nzZ, nzW;
    private float pzX, pzY, pzZ, pzW;

    /**
     * Create a frustum whose six planes are all zero.
     * <p>
     * Fill them in with {@link #set(Float4x4R)} before testing anything: on an
     * all-zero frustum every signed distance is zero, so every test reports the
     * argument as inside.
     */
    public Frustum() {
    }

    /**
     * Create a frustum from the planes of {@code m}, normalized so sphere tests work
     * and assuming OpenGL's <code>[-1, 1]</code> clip-space depth range.
     * <p>
     * Equivalent to {@link #set(Float4x4R, boolean, boolean) set(m, true, false)}.
     *
     * @param m the matrix to extract the frustum planes from
     */
    public Frustum(Float4x4R m) {
        set(m, true, false);
    }

    /**
     * Create a frustum from the planes of {@code m}, assuming OpenGL's
     * <code>[-1, 1]</code> clip-space depth range.
     * <p>
     * Equivalent to
     * {@link #set(Float4x4R, boolean, boolean) set(m, allowTestSpheres, false)}.
     *
     * @param m the matrix to extract the frustum planes from
     * @param allowTestSpheres whether to normalize the planes so sphere tests work
     */
    public Frustum(Float4x4R m, boolean allowTestSpheres) {
        set(m, allowTestSpheres, false);
    }

    /**
     * Build the frustum from {@code m}, which uses the given clip-space depth
     * convention.
     *
     * @param m the matrix to extract the frustum planes from
     * @param allowTestSpheres whether to normalize the planes so sphere tests work
     * @param zeroBasedDepth whether {@code m} maps the view volume onto a
     *        <code>[0, 1]</code> clip-space depth range (Vulkan / Direct3D, i.e.
     *        DepthRange ZERO_TO_ONE) instead of OpenGL's
     *        <code>[-1, 1]</code> (NEGATIVE_ONE_TO_ONE)
     */
    public Frustum(Float4x4R m, boolean allowTestSpheres, boolean zeroBasedDepth) {
        set(m, allowTestSpheres, zeroBasedDepth);
    }

    /**
     * Extract the six frustum planes from {@code m}, normalized so sphere tests work
     * and assuming OpenGL's <code>[-1, 1]</code> clip-space depth range.
     * <p>
     * Equivalent to {@link #set(Float4x4R, boolean, boolean) set(m, true, false)}.
     *
     * @param m the matrix to extract the frustum planes from
     * @return this
     */
    public Frustum set(Float4x4R m) {
        return set(m, true, false);
    }

    /**
     * Extract the six frustum planes from {@code m}, assuming OpenGL's
     * <code>[-1, 1]</code> clip-space depth range.
     * <p>
     * Equivalent to
     * {@link #set(Float4x4R, boolean, boolean) set(m, allowTestSpheres, false)}.
     *
     * @param m the matrix to extract the frustum planes from
     * @param allowTestSpheres whether to normalize the planes so sphere tests work
     * @return this
     */
    public Frustum set(Float4x4R m, boolean allowTestSpheres) {
        return set(m, allowTestSpheres, false);
    }

    /**
     * Extract the six frustum planes from {@code m}.
     * <p>
     * The near/far planes depend on the clip-space depth convention {@code m}
     * was built with: OpenGL maps the view volume onto <code>[-1, 1]</code>, so
     * both planes come from a combination with the w row, whereas Vulkan /
     * Direct3D map it onto <code>[0, 1]</code>, where the near plane is the z
     * row alone. Passing the wrong value silently mis-places a plane and the
     * culling results are wrong.
     *
     * @param m the matrix to extract the frustum planes from
     * @param allowTestSpheres whether to normalize the planes so sphere tests work
     * @param zeroBasedDepth whether {@code m} maps the view volume onto a
     *        <code>[0, 1]</code> clip-space depth range (Vulkan / Direct3D, i.e.
     *        DepthRange ZERO_TO_ONE) instead of OpenGL's
     *        <code>[-1, 1]</code> (NEGATIVE_ONE_TO_ONE)
     * @return this
     */
    public Frustum set(Float4x4R m, boolean allowTestSpheres, boolean zeroBasedDepth) {
        float invl;
        nxX = m.m30() + m.m00(); nxY = m.m31() + m.m01(); nxZ = m.m32() + m.m02(); nxW = m.m33() + m.m03();
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(nxX * nxX + nxY * nxY + nxZ * nxZ);
            nxX *= invl; nxY *= invl; nxZ *= invl; nxW *= invl;
        }
        pxX = m.m30() - m.m00(); pxY = m.m31() - m.m01(); pxZ = m.m32() - m.m02(); pxW = m.m33() - m.m03();
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(pxX * pxX + pxY * pxY + pxZ * pxZ);
            pxX *= invl; pxY *= invl; pxZ *= invl; pxW *= invl;
        }
        nyX = m.m30() + m.m10(); nyY = m.m31() + m.m11(); nyZ = m.m32() + m.m12(); nyW = m.m33() + m.m13();
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(nyX * nyX + nyY * nyY + nyZ * nyZ);
            nyX *= invl; nyY *= invl; nyZ *= invl; nyW *= invl;
        }
        pyX = m.m30() - m.m10(); pyY = m.m31() - m.m11(); pyZ = m.m32() - m.m12(); pyW = m.m33() - m.m13();
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(pyX * pyX + pyY * pyY + pyZ * pyZ);
            pyX *= invl; pyY *= invl; pyZ *= invl; pyW *= invl;
        }
        if (zeroBasedDepth) {
            nzX = m.m20(); nzY = m.m21(); nzZ = m.m22(); nzW = m.m23();
        } else {
            nzX = m.m30() + m.m20(); nzY = m.m31() + m.m21(); nzZ = m.m32() + m.m22(); nzW = m.m33() + m.m23();
        }
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(nzX * nzX + nzY * nzY + nzZ * nzZ);
            nzX *= invl; nzY *= invl; nzZ *= invl; nzW *= invl;
        }
        pzX = m.m30() - m.m20(); pzY = m.m31() - m.m21(); pzZ = m.m32() - m.m22(); pzW = m.m33() - m.m23();
        if (allowTestSpheres) {
            invl = 1.0f / (float) Math.sqrt(pzX * pzX + pzY * pzY + pzZ * pzZ);
            pzX *= invl; pzY *= invl; pzZ *= invl; pzW *= invl;
        }
        return this;
    }

    /** The x coefficient (plane normal component) of the left (-X) plane. */
    public float nxX() { return nxX; }
    /** The y coefficient (plane normal component) of the left (-X) plane. */
    public float nxY() { return nxY; }
    /** The z coefficient (plane normal component) of the left (-X) plane. */
    public float nxZ() { return nxZ; }
    /** The w coefficient (signed distance from origin) of the left (-X) plane. */
    public float nxW() { return nxW; }

    /** The x coefficient (plane normal component) of the right (+X) plane. */
    public float pxX() { return pxX; }
    /** The y coefficient (plane normal component) of the right (+X) plane. */
    public float pxY() { return pxY; }
    /** The z coefficient (plane normal component) of the right (+X) plane. */
    public float pxZ() { return pxZ; }
    /** The w coefficient (signed distance from origin) of the right (+X) plane. */
    public float pxW() { return pxW; }

    /** The x coefficient (plane normal component) of the bottom (-Y) plane. */
    public float nyX() { return nyX; }
    /** The y coefficient (plane normal component) of the bottom (-Y) plane. */
    public float nyY() { return nyY; }
    /** The z coefficient (plane normal component) of the bottom (-Y) plane. */
    public float nyZ() { return nyZ; }
    /** The w coefficient (signed distance from origin) of the bottom (-Y) plane. */
    public float nyW() { return nyW; }

    /** The x coefficient (plane normal component) of the top (+Y) plane. */
    public float pyX() { return pyX; }
    /** The y coefficient (plane normal component) of the top (+Y) plane. */
    public float pyY() { return pyY; }
    /** The z coefficient (plane normal component) of the top (+Y) plane. */
    public float pyZ() { return pyZ; }
    /** The w coefficient (signed distance from origin) of the top (+Y) plane. */
    public float pyW() { return pyW; }

    /** The x coefficient (plane normal component) of the near (-Z) plane. */
    public float nzX() { return nzX; }
    /** The y coefficient (plane normal component) of the near (-Z) plane. */
    public float nzY() { return nzY; }
    /** The z coefficient (plane normal component) of the near (-Z) plane. */
    public float nzZ() { return nzZ; }
    /** The w coefficient (signed distance from origin) of the near (-Z) plane. */
    public float nzW() { return nzW; }

    /** The x coefficient (plane normal component) of the far (+Z) plane. */
    public float pzX() { return pzX; }
    /** The y coefficient (plane normal component) of the far (+Z) plane. */
    public float pzY() { return pzY; }
    /** The z coefficient (plane normal component) of the far (+Z) plane. */
    public float pzZ() { return pzZ; }
    /** The w coefficient (signed distance from origin) of the far (+Z) plane. */
    public float pzW() { return pzW; }

    /**
     * Test whether {@code point} is inside the frustum.
     *
     * @param point the point to test
     * @return <code>true</code> iff the point is inside the frustum
     */
    public boolean testPoint(Float3R point) {
        return testPoint(point.x(), point.y(), point.z());
    }

    /**
     * Test whether the point <code>(x, y, z)</code> is inside the frustum.
     * <p>
     * Exact, unlike the volume tests: a point lying exactly on a plane counts as
     * inside.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @param z the z coordinate of the point
     * @return <code>true</code> iff the point is inside the frustum
     */
    public boolean testPoint(float x, float y, float z) {
        return nxX * x + nxY * y + nxZ * z + nxW >= 0 &&
               pxX * x + pxY * y + pxZ * z + pxW >= 0 &&
               nyX * x + nyY * y + nyZ * z + nyW >= 0 &&
               pyX * x + pyY * y + pyZ * z + pyW >= 0 &&
               nzX * x + nzY * y + nzZ * z + nzW >= 0 &&
               pzX * x + pzY * y + pzZ * z + pzW >= 0;
    }

    /**
     * Test whether the sphere around {@code center} with radius {@code radius} is
     * partly or completely inside the frustum.
     *
     * @param center the center of the sphere
     * @param radius the radius of the sphere
     * @return <code>true</code> iff the sphere is partly or completely inside the frustum
     */
    public boolean testSphere(Float3R center, float radius) {
        return testSphere(center.x(), center.y(), center.z(), radius);
    }

    /**
     * Test whether the sphere around <code>(x, y, z)</code> with radius {@code r} is
     * partly or completely inside the frustum.
     * <p>
     * The frustum must have been built with <code>allowTestSpheres = true</code>:
     * un-normalized planes do not measure distances in world units, so the radius
     * cannot be compared against them. The test is conservative - a sphere in a
     * corner region outside the frustum can be reported as intersecting - but never
     * reports an intersecting sphere as outside.
     *
     * @param x the x coordinate of the sphere center
     * @param y the y coordinate of the sphere center
     * @param z the z coordinate of the sphere center
     * @param r the radius of the sphere
     * @return <code>true</code> iff the sphere is partly or completely inside the frustum
     */
    public boolean testSphere(float x, float y, float z, float r) {
        return nxX * x + nxY * y + nxZ * z + nxW >= -r &&
               pxX * x + pxY * y + pxZ * z + pxW >= -r &&
               nyX * x + nyY * y + nyZ * z + nyW >= -r &&
               pyX * x + pyY * y + pyZ * z + pyW >= -r &&
               nzX * x + nzY * y + nzZ * z + nzW >= -r &&
               pzX * x + pzY * y + pzZ * z + pzW >= -r;
    }

    /**
     * Test whether {@code sphere} is partly or completely inside the frustum.
     *
     * @param sphere the sphere to test
     * @return <code>true</code> iff the sphere is partly or completely inside the frustum
     */
    public boolean testSphere(FloatSphereR sphere) {
        return testSphere(sphere.x(), sphere.y(), sphere.z(), sphere.r());
    }

    /**
     * Determine how the sphere around {@code center} with radius {@code radius}
     * relates to the frustum.
     *
     * @param center the center of the sphere
     * @param radius the radius of the sphere
     * @return how the sphere relates to the frustum
     */
    public Intersection intersectSphere(Float3R center, float radius) {
        return intersectSphere(center.x(), center.y(), center.z(), radius);
    }

    /**
     * Determine how the sphere around <code>(x, y, z)</code> with radius {@code r}
     * relates to the frustum.
     * <p>
     * Like {@link #testSphere(float, float, float, float)} this needs a frustum built
     * with <code>allowTestSpheres = true</code>, and is conservative: a sphere in a
     * corner region outside the frustum is reported as {@link Intersection#INTERSECT}
     * rather than {@link Intersection#OUTSIDE}. {@link Intersection#INSIDE} and
     * {@link Intersection#OUTSIDE} are never reported wrongly in the other direction.
     *
     * @param x the x coordinate of the sphere center
     * @param y the y coordinate of the sphere center
     * @param z the z coordinate of the sphere center
     * @param r the radius of the sphere
     * @return how the sphere relates to the frustum
     */
    public Intersection intersectSphere(float x, float y, float z, float r) {
        boolean inside = true;
        float dist;
        dist = nxX * x + nxY * y + nxZ * z + nxW;
        if (dist >= -r) {
            inside &= dist >= r;
            dist = pxX * x + pxY * y + pxZ * z + pxW;
            if (dist >= -r) {
                inside &= dist >= r;
                dist = nyX * x + nyY * y + nyZ * z + nyW;
                if (dist >= -r) {
                    inside &= dist >= r;
                    dist = pyX * x + pyY * y + pyZ * z + pyW;
                    if (dist >= -r) {
                        inside &= dist >= r;
                        dist = nzX * x + nzY * y + nzZ * z + nzW;
                        if (dist >= -r) {
                            inside &= dist >= r;
                            dist = pzX * x + pzY * y + pzZ * z + pzW;
                            if (dist >= -r) {
                                inside &= dist >= r;
                                return inside ? Intersection.INSIDE : Intersection.INTERSECT;
                            }
                        }
                    }
                }
            }
        }
        return Intersection.OUTSIDE;
    }

    /**
     * Determine how {@code sphere} relates to the frustum.
     *
     * @param sphere the sphere to test
     * @return how the sphere relates to the frustum
     */
    public Intersection intersectSphere(FloatSphereR sphere) {
        return intersectSphere(sphere.x(), sphere.y(), sphere.z(), sphere.r());
    }

    /**
     * Test whether the axis-aligned box spanned by {@code min} and {@code max} is
     * partly or completely inside the frustum.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @return <code>true</code> iff the box is partly or completely inside the frustum
     */
    public boolean testAabb(Float3R min, Float3R max) {
        return testAabb(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }

    /**
     * Test whether the axis-aligned box spanned by <code>(minX, minY, minZ)</code>
     * and <code>(maxX, maxY, maxZ)</code> is partly or completely inside the frustum.
     * <p>
     * The test is conservative: it only asks whether the box lies completely outside
     * one single plane, so a box in a corner region outside the frustum can be
     * reported as intersecting. A box that really does intersect is never reported as
     * outside, which is what culling needs.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @return <code>true</code> iff the box is partly or completely inside the frustum
     */
    public boolean testAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) >= -nxW &&
               pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) >= -pxW &&
               nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) >= -nyW &&
               pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) >= -pyW &&
               nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) >= -nzW &&
               pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) >= -pzW;
    }

    /**
     * Test whether {@code aabb} is partly or completely inside the frustum.
     *
     * @param aabb the axis-aligned box to test
     * @return <code>true</code> iff the box is partly or completely inside the frustum
     */
    public boolean testAabb(FloatAABBR aabb) {
        return testAabb(aabb.minX(), aabb.minY(), aabb.minZ(),
                       aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }

    /**
     * Test whether the rectangle spanned by {@code min} and {@code max} in the XY
     * plane at <code>z = 0</code> is partly or completely within the frustum.
     *
     * @param min the corner of the rectangle with the smaller coordinates
     * @param max the corner of the rectangle with the larger coordinates
     * @return <code>true</code> iff the rectangle is partly or completely within the frustum
     */
    public boolean testPlaneXY(Float2R min, Float2R max) {
        return testPlaneXY(min.x(), min.y(), max.x(), max.y());
    }

    /**
     * Test whether the rectangle spanned by <code>(minX, minY)</code> and
     * <code>(maxX, maxY)</code> in the XY plane at <code>z = 0</code> is partly or
     * completely within the frustum.
     * <p>
     * The z term of each plane drops out because the rectangle's <code>z</code> is
     * zero - this is <em>not</em> a test of the rectangle extended infinitely along
     * Z. Conservative in the same way {@link #testAabb(float, float, float, float, float, float)} is.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @return <code>true</code> iff the rectangle is partly or completely within the frustum
     */
    public boolean testPlaneXY(float minX, float minY, float maxX, float maxY) {
        return nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) >= -nxW &&
               pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) >= -pxW &&
               nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) >= -nyW &&
               pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) >= -pyW &&
               nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) >= -nzW &&
               pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) >= -pzW;
    }

    /**
     * Test whether the given rectangle, lying in the XY plane at <code>z = 0</code>,
     * is partly or completely within the frustum. The rect's x/y axes map to
     * world X/Y. The z term of each plane drops out because the rectangle's
     * <code>z</code> is zero - this is <em>not</em> a test of the rectangle
     * extended infinitely along Z.
     *
     * @param rect the rectangle to test
     * @return <code>true</code> iff the rectangle is partly or completely within the frustum
     */
    public boolean testPlaneXY(FloatRectR rect) {
        return testPlaneXY(rect.minX(), rect.minY(), rect.maxX(), rect.maxY());
    }

    /**
     * Test whether the rectangle spanned by <code>(minX, minZ)</code> and
     * <code>(maxX, maxZ)</code> in the XZ plane at <code>y = 0</code> is partly or
     * completely within the frustum.
     * <p>
     * The y term of each plane drops out because the rectangle's <code>y</code> is
     * zero - this is <em>not</em> a test of the rectangle extended infinitely along
     * Y. Conservative in the same way {@link #testAabb(float, float, float, float, float, float)} is.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @return <code>true</code> iff the rectangle is partly or completely within the frustum
     */
    public boolean testPlaneXZ(float minX, float minZ, float maxX, float maxZ) {
        return nxX * (nxX < 0 ? minX : maxX) + nxZ * (nxZ < 0 ? minZ : maxZ) >= -nxW &&
               pxX * (pxX < 0 ? minX : maxX) + pxZ * (pxZ < 0 ? minZ : maxZ) >= -pxW &&
               nyX * (nyX < 0 ? minX : maxX) + nyZ * (nyZ < 0 ? minZ : maxZ) >= -nyW &&
               pyX * (pyX < 0 ? minX : maxX) + pyZ * (pyZ < 0 ? minZ : maxZ) >= -pyW &&
               nzX * (nzX < 0 ? minX : maxX) + nzZ * (nzZ < 0 ? minZ : maxZ) >= -nzW &&
               pzX * (pzX < 0 ? minX : maxX) + pzZ * (pzZ < 0 ? minZ : maxZ) >= -pzW;
    }

    /**
     * Test whether the given rectangle, lying in the XZ plane at <code>y = 0</code>,
     * is partly or completely within the frustum. The rect's x-axis maps to
     * world X and - since the rect lies in the XZ plane - its <em>y</em>-axis
     * maps to world <em>Z</em>: {@code rect.minY()} / {@code rect.maxY()} are
     * passed as {@code minZ} / {@code maxZ}. The y term of each plane drops out
     * because the rectangle's <code>y</code> is zero - this is <em>not</em> a
     * test of the rectangle extended infinitely along Y.
     *
     * @param rect the rectangle to test, with its y-axis read as world Z
     * @return <code>true</code> iff the rectangle is partly or completely within the frustum
     */
    public boolean testPlaneXZ(FloatRectR rect) {
        return testPlaneXZ(rect.minX(), rect.minY(), rect.maxX(), rect.maxY());
    }

    /**
     * Determine how the axis-aligned box spanned by {@code min} and {@code max}
     * relates to the frustum.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(Float3R min, Float3R max) {
        return intersectAabb(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }

    /**
     * Determine how the axis-aligned box spanned by <code>(minX, minY, minZ)</code>
     * and <code>(maxX, maxY, maxZ)</code> relates to the frustum.
     * <p>
     * {@link Intersection#INSIDE} is exact. {@link Intersection#INTERSECT} is
     * conservative in the same way
     * {@link #testAabb(float, float, float, float, float, float)} is: a box in a corner
     * region outside the frustum can be reported as intersecting instead of
     * {@link Intersection#OUTSIDE}. To learn <em>which</em> plane culls an outside box -
     * and to feed that back as a coherency hint next frame - use
     * {@link #cullingPlane(float, float, float, float, float, float)} instead.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        boolean inside = true;
        if (nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) < -nxW) return Intersection.OUTSIDE;
        inside &= nxX * (nxX < 0 ? maxX : minX) + nxY * (nxY < 0 ? maxY : minY) + nxZ * (nxZ < 0 ? maxZ : minZ) >= -nxW;
        if (pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) < -pxW) return Intersection.OUTSIDE;
        inside &= pxX * (pxX < 0 ? maxX : minX) + pxY * (pxY < 0 ? maxY : minY) + pxZ * (pxZ < 0 ? maxZ : minZ) >= -pxW;
        if (nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) < -nyW) return Intersection.OUTSIDE;
        inside &= nyX * (nyX < 0 ? maxX : minX) + nyY * (nyY < 0 ? maxY : minY) + nyZ * (nyZ < 0 ? maxZ : minZ) >= -nyW;
        if (pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) < -pyW) return Intersection.OUTSIDE;
        inside &= pyX * (pyX < 0 ? maxX : minX) + pyY * (pyY < 0 ? maxY : minY) + pyZ * (pyZ < 0 ? maxZ : minZ) >= -pyW;
        if (nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) < -nzW) return Intersection.OUTSIDE;
        inside &= nzX * (nzX < 0 ? maxX : minX) + nzY * (nzY < 0 ? maxY : minY) + nzZ * (nzZ < 0 ? maxZ : minZ) >= -nzW;
        if (pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) < -pzW) return Intersection.OUTSIDE;
        inside &= pzX * (pzX < 0 ? maxX : minX) + pzY * (pzY < 0 ? maxY : minY) + pzZ * (pzZ < 0 ? maxZ : minZ) >= -pzW;
        return inside ? Intersection.INSIDE : Intersection.INTERSECT;
    }

    /**
     * Determine how {@code aabb} relates to the frustum.
     *
     * @param aabb the axis-aligned box to test
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(FloatAABBR aabb) {
        return intersectAabb(aabb.minX(), aabb.minY(), aabb.minZ(),
                            aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }

    /**
     * Determine how the axis-aligned box spanned by {@code min} and {@code max}
     * relates to the frustum, letting only the planes selected by {@code mask} cull it.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(Float3R min, Float3R max, int mask) {
        return intersectAabb(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), mask);
    }

    /**
     * Determine how the axis-aligned box spanned by <code>(minX, minY, minZ)</code>
     * and <code>(maxX, maxY, maxZ)</code> relates to the frustum, letting only the
     * planes selected by {@code mask} cull it.
     * <p>
     * Masking a plane off is the standard optimization for a bounding-volume
     * hierarchy: once a parent node is known to be fully inside a plane, none of its
     * children can be culled by that plane either. Verdicts are the same as for
     * {@link #intersectAabb(float, float, float, float, float, float)}.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box; a plane whose bit is clear cannot cull it,
     *        but still takes part in the {@link Intersection#INSIDE} decision
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int mask) {
        boolean inside = true;
        if ((mask & PLANE_MASK_NX) != 0 && nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) < -nxW)
            return Intersection.OUTSIDE;
        inside &= nxX * (nxX < 0 ? maxX : minX) + nxY * (nxY < 0 ? maxY : minY) + nxZ * (nxZ < 0 ? maxZ : minZ) >= -nxW;
        if ((mask & PLANE_MASK_PX) != 0 && pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) < -pxW)
            return Intersection.OUTSIDE;
        inside &= pxX * (pxX < 0 ? maxX : minX) + pxY * (pxY < 0 ? maxY : minY) + pxZ * (pxZ < 0 ? maxZ : minZ) >= -pxW;
        if ((mask & PLANE_MASK_NY) != 0 && nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) < -nyW)
            return Intersection.OUTSIDE;
        inside &= nyX * (nyX < 0 ? maxX : minX) + nyY * (nyY < 0 ? maxY : minY) + nyZ * (nyZ < 0 ? maxZ : minZ) >= -nyW;
        if ((mask & PLANE_MASK_PY) != 0 && pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) < -pyW)
            return Intersection.OUTSIDE;
        inside &= pyX * (pyX < 0 ? maxX : minX) + pyY * (pyY < 0 ? maxY : minY) + pyZ * (pyZ < 0 ? maxZ : minZ) >= -pyW;
        if ((mask & PLANE_MASK_NZ) != 0 && nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) < -nzW)
            return Intersection.OUTSIDE;
        inside &= nzX * (nzX < 0 ? maxX : minX) + nzY * (nzY < 0 ? maxY : minY) + nzZ * (nzZ < 0 ? maxZ : minZ) >= -nzW;
        if ((mask & PLANE_MASK_PZ) != 0 && pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) < -pzW)
            return Intersection.OUTSIDE;
        inside &= pzX * (pzX < 0 ? maxX : minX) + pzY * (pzY < 0 ? maxY : minY) + pzZ * (pzZ < 0 ? maxZ : minZ) >= -pzW;
        return inside ? Intersection.INSIDE : Intersection.INTERSECT;
    }

    /**
     * Determine how {@code aabb} relates to the frustum, letting only the planes
     * selected by {@code mask} cull it.
     *
     * @param aabb the axis-aligned box to test
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @return how the box relates to the frustum
     */
    public Intersection intersectAabb(FloatAABBR aabb, int mask) {
        return intersectAabb(aabb.minX(), aabb.minY(), aabb.minZ(),
                            aabb.maxX(), aabb.maxY(), aabb.maxZ(), mask);
    }

    /**
     * Determine which frustum plane culls the axis-aligned box spanned by {@code min}
     * and {@code max}.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(Float3R min, Float3R max) {
        return cullingPlane(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }

    /**
     * Determine which frustum plane culls the axis-aligned box spanned by
     * <code>(minX, minY, minZ)</code> and <code>(maxX, maxY, maxZ)</code>.
     * <p>
     * A <code>null</code> result means the box is not culled - it is inside the frustum
     * or straddles it. Unlike
     * {@link #intersectAabb(float, float, float, float, float, float)} this does not
     * distinguish those two cases, and is correspondingly cheaper: it never evaluates
     * the fully-inside half of the test.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) < -nxW) return FrustumPlane.NX;
        if (pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) < -pxW) return FrustumPlane.PX;
        if (nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) < -nyW) return FrustumPlane.NY;
        if (pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) < -pyW) return FrustumPlane.PY;
        if (nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) < -nzW) return FrustumPlane.NZ;
        if (pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) < -pzW) return FrustumPlane.PZ;
        return null;
    }

    /**
     * Determine which frustum plane culls {@code aabb}.
     *
     * @param aabb the axis-aligned box to test
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(FloatAABBR aabb) {
        return cullingPlane(aabb.minX(), aabb.minY(), aabb.minZ(),
                            aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }

    /**
     * Determine which of the planes selected by {@code mask} culls the axis-aligned box
     * spanned by {@code min} and {@code max}.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(Float3R min, Float3R max, int mask) {
        return cullingPlane(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), mask);
    }

    /**
     * Determine which of the planes selected by {@code mask} culls the axis-aligned box
     * spanned by <code>(minX, minY, minZ)</code> and <code>(maxX, maxY, maxZ)</code>.
     * <p>
     * Masking a plane off is the standard optimization for a bounding-volume
     * hierarchy: once a parent node is known to be fully inside a plane, none of its
     * children can be culled by that plane either.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int mask) {
        if ((mask & PLANE_MASK_NX) != 0 && nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) < -nxW) return FrustumPlane.NX;
        if ((mask & PLANE_MASK_PX) != 0 && pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) < -pxW) return FrustumPlane.PX;
        if ((mask & PLANE_MASK_NY) != 0 && nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) < -nyW) return FrustumPlane.NY;
        if ((mask & PLANE_MASK_PY) != 0 && pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) < -pyW) return FrustumPlane.PY;
        if ((mask & PLANE_MASK_NZ) != 0 && nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) < -nzW) return FrustumPlane.NZ;
        if ((mask & PLANE_MASK_PZ) != 0 && pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) < -pzW) return FrustumPlane.PZ;
        return null;
    }

    /**
     * Determine which of the planes selected by {@code mask} culls {@code aabb}.
     *
     * @param aabb the axis-aligned box to test
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(FloatAABBR aabb, int mask) {
        return cullingPlane(aabb.minX(), aabb.minY(), aabb.minZ(),
                            aabb.maxX(), aabb.maxY(), aabb.maxZ(), mask);
    }

    /**
     * Determine which of the planes selected by {@code mask} culls the axis-aligned box
     * spanned by {@code min} and {@code max}, trying {@code hint} first.
     *
     * @param min the corner of the box with the smaller coordinates
     * @param max the corner of the box with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @param hint the plane to test first, or <code>null</code> for no hint
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(Float3R min, Float3R max, int mask, FrustumPlane hint) {
        return cullingPlane(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), mask, hint);
    }

    /**
     * Determine which of the planes selected by {@code mask} culls the axis-aligned box
     * spanned by <code>(minX, minY, minZ)</code> and <code>(maxX, maxY, maxZ)</code>,
     * trying {@code hint} first.
     * <p>
     * Frame-to-frame coherency: an object culled by one plane last frame is likely to
     * be culled by the same plane again, so testing that plane first usually ends the
     * query after a single comparison. Feed the previous call's result straight back -
     * its <code>null</code> (nothing culled the box) is a valid "no hint" argument:
     * <pre>{@code
     * hint = frustum.cullingPlane(box, mask, hint);
     * if (hint != null) skip(box);
     * }</pre>
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @param hint the plane to test first, or <code>null</code> for no hint; only
     *        consulted when its bit is set in {@code mask}
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int mask, FrustumPlane hint) {
        // Coherency check: if hint culled previously, it likely culls again.
        if (hint != null && (mask & (1 << hint.ordinal())) != 0
                && cullsAabb(hint, minX, minY, minZ, maxX, maxY, maxZ))
            return hint;
        return cullingPlane(minX, minY, minZ, maxX, maxY, maxZ, mask);
    }

    /**
     * Determine which of the planes selected by {@code mask} culls {@code aabb}, trying
     * {@code hint} first.
     *
     * @param aabb the axis-aligned box to test
     * @param mask a bit mask of the <code>PLANE_MASK_*</code> constants selecting the
     *        planes that may cull the box
     * @param hint the plane to test first, or <code>null</code> for no hint
     * @return the plane that culls the box, or <code>null</code> if none does
     */
    public FrustumPlane cullingPlane(FloatAABBR aabb, int mask, FrustumPlane hint) {
        return cullingPlane(aabb.minX(), aabb.minY(), aabb.minZ(),
                            aabb.maxX(), aabb.maxY(), aabb.maxZ(), mask, hint);
    }

    /**
     * Compute the smallest signed distance any corner of the axis-aligned box spanned
     * by <code>(minX, minY, minZ)</code> and <code>(maxX, maxY, maxZ)</code> has from
     * the given frustum plane.
     * <p>
     * This is the minimum of the plane equation over the box's eight corners, so it
     * is negative exactly when at least one corner lies outside the plane, and
     * non-negative exactly when the whole box lies in that plane's inside half-space.
     * It is a distance in world units only when the frustum was built with
     * <code>allowTestSpheres = true</code>; otherwise it is scaled by the length of
     * the plane normal and only its sign and ordering are meaningful.
     *
     * @param minX the x coordinate of the corner with the smaller coordinates
     * @param minY the y coordinate of the corner with the smaller coordinates
     * @param minZ the z coordinate of the corner with the smaller coordinates
     * @param maxX the x coordinate of the corner with the larger coordinates
     * @param maxY the y coordinate of the corner with the larger coordinates
     * @param maxZ the z coordinate of the corner with the larger coordinates
     * @param plane the plane to measure against
     * @return the signed distance of the box corner least inside the plane
     */
    public float distanceToPlane(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, FrustumPlane plane) {
        switch (plane) {
            case NX: return nxX * (nxX < 0 ? maxX : minX) + nxY * (nxY < 0 ? maxY : minY) + nxZ * (nxZ < 0 ? maxZ : minZ) + nxW;
            case PX: return pxX * (pxX < 0 ? maxX : minX) + pxY * (pxY < 0 ? maxY : minY) + pxZ * (pxZ < 0 ? maxZ : minZ) + pxW;
            case NY: return nyX * (nyX < 0 ? maxX : minX) + nyY * (nyY < 0 ? maxY : minY) + nyZ * (nyZ < 0 ? maxZ : minZ) + nyW;
            case PY: return pyX * (pyX < 0 ? maxX : minX) + pyY * (pyY < 0 ? maxY : minY) + pyZ * (pyZ < 0 ? maxZ : minZ) + pyW;
            case NZ: return nzX * (nzX < 0 ? maxX : minX) + nzY * (nzY < 0 ? maxY : minY) + nzZ * (nzZ < 0 ? maxZ : minZ) + nzW;
            case PZ: return pzX * (pzX < 0 ? maxX : minX) + pzY * (pzY < 0 ? maxY : minY) + pzZ * (pzZ < 0 ? maxZ : minZ) + pzW;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
    }

    /**
     * Test whether the line segment from {@code a} to {@code b} is partly or
     * completely inside the frustum.
     *
     * @param a the first end point of the line segment
     * @param b the second end point of the line segment
     * @return <code>true</code> iff the line segment is partly or completely inside
     *         the frustum
     */
    public boolean testLineSegment(Float3R a, Float3R b) {
        return testLineSegment(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
    }

    /**
     * Test whether the line segment from <code>(aX, aY, aZ)</code> to
     * <code>(bX, bY, bZ)</code> is partly or completely inside the frustum.
     * <p>
     * Exact, unlike the volume tests: the segment is clipped against each plane in
     * turn, so a segment passing through a corner region outside the frustum is
     * correctly reported as outside.
     *
     * @param aX the x coordinate of the first end point
     * @param aY the y coordinate of the first end point
     * @param aZ the z coordinate of the first end point
     * @param bX the x coordinate of the second end point
     * @param bY the y coordinate of the second end point
     * @param bZ the z coordinate of the second end point
     * @return <code>true</code> iff the line segment is partly or completely inside
     *         the frustum
     */
    public boolean testLineSegment(float aX, float aY, float aZ, float bX, float bY, float bZ) {
        float da, db;
        da = nxX * aX + nxY * aY + nxZ * aZ + nxW;
        db = nxX * bX + nxY * bY + nxZ * bZ + nxW;
        if (da < 0.0f && db < 0.0f) return false;
        if (da * db < 0.0f) {
            float p = Math.abs(da) / Math.abs(db - da);
            float dx = (bX - aX) * p + aX, dy = (bY - aY) * p + aY, dz = (bZ - aZ) * p + aZ;
            if (da < 0.0f) { aX = dx; aY = dy; aZ = dz; }
            else           { bX = dx; bY = dy; bZ = dz; }
        }
        da = pxX * aX + pxY * aY + pxZ * aZ + pxW;
        db = pxX * bX + pxY * bY + pxZ * bZ + pxW;
        if (da < 0.0f && db < 0.0f) return false;
        if (da * db < 0.0f) {
            float p = Math.abs(da) / Math.abs(db - da);
            float dx = (bX - aX) * p + aX, dy = (bY - aY) * p + aY, dz = (bZ - aZ) * p + aZ;
            if (da < 0.0f) { aX = dx; aY = dy; aZ = dz; }
            else           { bX = dx; bY = dy; bZ = dz; }
        }
        da = nyX * aX + nyY * aY + nyZ * aZ + nyW;
        db = nyX * bX + nyY * bY + nyZ * bZ + nyW;
        if (da < 0.0f && db < 0.0f) return false;
        if (da * db < 0.0f) {
            float p = Math.abs(da) / Math.abs(db - da);
            float dx = (bX - aX) * p + aX, dy = (bY - aY) * p + aY, dz = (bZ - aZ) * p + aZ;
            if (da < 0.0f) { aX = dx; aY = dy; aZ = dz; }
            else           { bX = dx; bY = dy; bZ = dz; }
        }
        da = pyX * aX + pyY * aY + pyZ * aZ + pyW;
        db = pyX * bX + pyY * bY + pyZ * bZ + pyW;
        if (da < 0.0f && db < 0.0f) return false;
        if (da * db < 0.0f) {
            float p = Math.abs(da) / Math.abs(db - da);
            float dx = (bX - aX) * p + aX, dy = (bY - aY) * p + aY, dz = (bZ - aZ) * p + aZ;
            if (da < 0.0f) { aX = dx; aY = dy; aZ = dz; }
            else           { bX = dx; bY = dy; bZ = dz; }
        }
        da = nzX * aX + nzY * aY + nzZ * aZ + nzW;
        db = nzX * bX + nzY * bY + nzZ * bZ + nzW;
        if (da < 0.0f && db < 0.0f) return false;
        if (da * db < 0.0f) {
            float p = Math.abs(da) / Math.abs(db - da);
            float dx = (bX - aX) * p + aX, dy = (bY - aY) * p + aY, dz = (bZ - aZ) * p + aZ;
            if (da < 0.0f) { aX = dx; aY = dy; aZ = dz; }
            else           { bX = dx; bY = dy; bZ = dz; }
        }
        da = pzX * aX + pzY * aY + pzZ * aZ + pzW;
        db = pzX * bX + pzY * bY + pzZ * bZ + pzW;
        return da >= 0.0f || db >= 0.0f;
    }

    private boolean cullsAabb(FrustumPlane plane, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        switch (plane) {
            case NX: return nxX * (nxX < 0 ? minX : maxX) + nxY * (nxY < 0 ? minY : maxY) + nxZ * (nxZ < 0 ? minZ : maxZ) < -nxW;
            case PX: return pxX * (pxX < 0 ? minX : maxX) + pxY * (pxY < 0 ? minY : maxY) + pxZ * (pxZ < 0 ? minZ : maxZ) < -pxW;
            case NY: return nyX * (nyX < 0 ? minX : maxX) + nyY * (nyY < 0 ? minY : maxY) + nyZ * (nyZ < 0 ? minZ : maxZ) < -nyW;
            case PY: return pyX * (pyX < 0 ? minX : maxX) + pyY * (pyY < 0 ? minY : maxY) + pyZ * (pyZ < 0 ? minZ : maxZ) < -pyW;
            case NZ: return nzX * (nzX < 0 ? minX : maxX) + nzY * (nzY < 0 ? minY : maxY) + nzZ * (nzZ < 0 ? minZ : maxZ) < -nzW;
            case PZ: return pzX * (pzX < 0 ? minX : maxX) + pzY * (pzY < 0 ? minY : maxY) + pzZ * (pzZ < 0 ? minZ : maxZ) < -pzW;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
    }
}
