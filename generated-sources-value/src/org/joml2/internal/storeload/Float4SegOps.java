package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface Float4SegOps {
    MemorySegment store(Float4 self, long offset, MemorySegment dest);
    Float4 load(long offset, MemorySegment src);
    MemorySegment storeDouble(Float4 self, long offset, MemorySegment dest);
    Float4 loadDouble(long offset, MemorySegment src);
}
