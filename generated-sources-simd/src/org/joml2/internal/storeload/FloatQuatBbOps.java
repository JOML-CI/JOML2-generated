package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public interface FloatQuatBbOps {
    DoubleBuffer storeAbsolute(FloatQuatImpl self, int index, DoubleBuffer buf);
    FloatQuat loadAbsolute(FloatQuatImpl self, int index, DoubleBuffer buf);
    ByteBuffer storeDoubleAbsolute(FloatQuatImpl self, int index, ByteBuffer buf);
    FloatQuat loadDoubleAbsolute(FloatQuatImpl self, int index, ByteBuffer buf);
}
