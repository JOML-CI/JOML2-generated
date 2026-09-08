package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface Double3SegOps {
    MemorySegment store(Double3 self, long offset, MemorySegment dest);
    Double3 load(long offset, MemorySegment src);
    MemorySegment storeFloat(Double3 self, long offset, MemorySegment dest);
    Double3 loadFloat(long offset, MemorySegment src);
}
