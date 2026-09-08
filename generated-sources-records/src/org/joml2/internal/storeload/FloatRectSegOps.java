package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface FloatRectSegOps {
    MemorySegment store(FloatRect self, long offset, MemorySegment dest);
    FloatRect load(long offset, MemorySegment src);
    MemorySegment storeDouble(FloatRect self, long offset, MemorySegment dest);
    FloatRect loadDouble(long offset, MemorySegment src);
}
