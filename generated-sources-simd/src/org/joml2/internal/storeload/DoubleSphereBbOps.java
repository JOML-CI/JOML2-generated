package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface DoubleSphereBbOps {
    FloatBuffer storeAbsolute(DoubleSphereImpl self, int index, FloatBuffer buf);
    DoubleSphere loadAbsolute(DoubleSphereImpl self, int index, FloatBuffer buf);
    ByteBuffer storeFloatAbsolute(DoubleSphereImpl self, int index, ByteBuffer buf);
    DoubleSphere loadFloatAbsolute(DoubleSphereImpl self, int index, ByteBuffer buf);
}
