package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;

public interface IntRectBbOps {
    LongBuffer storeAbsolute(IntRectImpl self, int index, LongBuffer buf);
    IntRect loadAbsolute(IntRectImpl self, int index, LongBuffer buf);
    ByteBuffer storeLongAbsolute(IntRectImpl self, int index, ByteBuffer buf);
    IntRect loadLongAbsolute(IntRectImpl self, int index, ByteBuffer buf);
}
