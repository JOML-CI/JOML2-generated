package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface FloatPlaneSegOps {
    MemorySegment store(FloatPlane self, long offset, MemorySegment dest);
    FloatPlane load(long offset, MemorySegment src);
    MemorySegment storeDouble(FloatPlane self, long offset, MemorySegment dest);
    FloatPlane loadDouble(long offset, MemorySegment src);
}
