package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatSphereRawOpsApi implements FloatSphereRawOps {
    public FloatSphere storeUnsafe(FloatSphere self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatSphere loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatSphere storeDoubleUnsafe(FloatSphere self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatSphere loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
