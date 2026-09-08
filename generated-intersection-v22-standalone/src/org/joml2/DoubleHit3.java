package org.joml2;

/**
 * The result of an intersection kernel that yields both a classification and a
 * {@link Double3}: {@link #code()} says which case the result falls in
 * (<code>0</code> = no intersection) and the components carry the result itself.
 * <p>
 * A boolean-valued kernel only ever reports <code>0</code> or <code>1</code> - prefer
 * {@link #hit()} there.
 * The region-classifying kernels report the matching
 * <code>POINT_ON_TRIANGLE_*</code> constant.
 *
 * @param code the case this result falls in, or <code>0</code> for no intersection
 * @param x the {@code x} component of the result
 * @param y the {@code y} component of the result
 * @param z the {@code z} component of the result
 */
public record DoubleHit3(int code, double x, double y, double z) {

    /** No intersection: {@link #code()} <code>0</code> and all components <code>0</code>. */
    public static final DoubleHit3 MISS = new DoubleHit3(0, 0, 0, 0);

    /**
     * Whether the kernel found an intersection, i.e. whether {@link #code()} is non-zero.
     *
     * @return <code>true</code> iff there is an intersection
     */
    public boolean hit() {
        return code != 0;
    }

    /**
     * The result components as a vector.
     *
     * @return a {@link Double3} holding the result components
     */
    public Double3 value() {
        return Joml.double3(x, y, z);
    }
}
