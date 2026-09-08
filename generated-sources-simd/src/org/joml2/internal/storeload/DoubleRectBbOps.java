package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface DoubleRectBbOps {
    FloatBuffer storeAbsolute(DoubleRectImpl self, int index, FloatBuffer buf);
    DoubleRect loadAbsolute(DoubleRectImpl self, int index, FloatBuffer buf);
    ByteBuffer storeFloatAbsolute(DoubleRectImpl self, int index, ByteBuffer buf);
    DoubleRect loadFloatAbsolute(DoubleRectImpl self, int index, ByteBuffer buf);
}
