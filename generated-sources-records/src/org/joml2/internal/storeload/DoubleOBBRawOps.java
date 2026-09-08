package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface DoubleOBBRawOps {
    DoubleOBB storeUnsafe(DoubleOBB self, long address);
    DoubleOBB loadUnsafe(long address);
    DoubleOBB storeFloatUnsafe(DoubleOBB self, long address);
    DoubleOBB loadFloatUnsafe(long address);
}
