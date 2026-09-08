package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface FloatTriangleSegOps {
    MemorySegment store(FloatTriangle self, long offset, MemorySegment dest);
    FloatTriangle load(long offset, MemorySegment src);
    MemorySegment storeDouble(FloatTriangle self, long offset, MemorySegment dest);
    FloatTriangle loadDouble(long offset, MemorySegment src);
}
