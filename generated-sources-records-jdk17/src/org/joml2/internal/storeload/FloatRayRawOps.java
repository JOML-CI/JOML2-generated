package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface FloatRayRawOps {
    FloatRay storeUnsafe(FloatRay self, long address);
    FloatRay loadUnsafe(long address);
    FloatRay storeDoubleUnsafe(FloatRay self, long address);
    FloatRay loadDoubleUnsafe(long address);
}
