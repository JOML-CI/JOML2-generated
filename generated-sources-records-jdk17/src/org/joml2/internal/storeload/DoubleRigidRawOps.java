package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface DoubleRigidRawOps {
    DoubleRigid storeUnsafe(DoubleRigid self, long address);
    DoubleRigid loadUnsafe(long address);
    DoubleRigid storeFloatUnsafe(DoubleRigid self, long address);
    DoubleRigid loadFloatUnsafe(long address);
}
