package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface Long3RawOps {
    Long3 storeUnsafe(Long3 self, long address);
    Long3 loadUnsafe(long address);
    Long3 storeIntUnsafe(Long3 self, long address);
    Long3 loadIntUnsafe(long address);
}
