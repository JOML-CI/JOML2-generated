package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface Byte2SegOps {
    MemorySegment store(Byte2 self, long offset, MemorySegment dest);
    Byte2 load(long offset, MemorySegment src);
    MemorySegment storeShort(Byte2 self, long offset, MemorySegment dest);
    Byte2 loadShort(long offset, MemorySegment src);
}
