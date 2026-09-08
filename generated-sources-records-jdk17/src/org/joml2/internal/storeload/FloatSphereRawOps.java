package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface FloatSphereRawOps {
    FloatSphere storeUnsafe(FloatSphere self, long address);
    FloatSphere loadUnsafe(long address);
    FloatSphere storeDoubleUnsafe(FloatSphere self, long address);
    FloatSphere loadDoubleUnsafe(long address);
}
