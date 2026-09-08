package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface FloatAABBRawOps {
    FloatAABB storeUnsafe(FloatAABB self, long address);
    FloatAABB loadUnsafe(long address);
    FloatAABB storeDoubleUnsafe(FloatAABB self, long address);
    FloatAABB loadDoubleUnsafe(long address);
}
