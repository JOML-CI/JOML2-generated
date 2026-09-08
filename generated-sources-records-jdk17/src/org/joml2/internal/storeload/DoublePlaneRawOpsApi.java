package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoublePlaneRawOpsApi implements DoublePlaneRawOps {
    public DoublePlane storeUnsafe(DoublePlane self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoublePlane loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoublePlane storeFloatUnsafe(DoublePlane self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoublePlane loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
