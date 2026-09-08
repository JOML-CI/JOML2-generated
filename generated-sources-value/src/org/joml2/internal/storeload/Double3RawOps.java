package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface Double3RawOps {
    Double3 storeUnsafe(Double3 self, long address);
    Double3 loadUnsafe(long address);
    Double3 storeFloatUnsafe(Double3 self, long address);
    Double3 loadFloatUnsafe(long address);
}
