package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import java.lang.foreign.MemorySegment;

public interface DoubleRigidSegOps {
    MemorySegment store(DoubleRigid self, long offset, MemorySegment dest);
    DoubleRigid load(long offset, MemorySegment src);
    MemorySegment storeFloat(DoubleRigid self, long offset, MemorySegment dest);
    DoubleRigid loadFloat(long offset, MemorySegment src);
}
