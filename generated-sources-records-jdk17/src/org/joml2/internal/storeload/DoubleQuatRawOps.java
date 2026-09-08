package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface DoubleQuatRawOps {
    DoubleQuat storeUnsafe(DoubleQuat self, long address);
    DoubleQuat loadUnsafe(long address);
    DoubleQuat storeFloatUnsafe(DoubleQuat self, long address);
    DoubleQuat loadFloatUnsafe(long address);
}
