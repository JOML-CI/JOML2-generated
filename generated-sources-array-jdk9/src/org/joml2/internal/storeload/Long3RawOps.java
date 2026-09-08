package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public interface Long3RawOps {
    Long3 storeUnsafe(Long3Impl self, long address);
    Long3 loadUnsafe(Long3Impl self, long address);
    Long3 storeIntUnsafe(Long3Impl self, long address);
    Long3 loadIntUnsafe(Long3Impl self, long address);
}
