package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.lang.foreign.MemorySegment;

public interface IntRectSegOps {
    MemorySegment store(IntRectImpl self, long offset, MemorySegment dest);
    IntRect load(IntRectImpl self, long offset, MemorySegment src);
    MemorySegment storeLong(IntRectImpl self, long offset, MemorySegment dest);
    IntRect loadLong(IntRectImpl self, long offset, MemorySegment src);
}
