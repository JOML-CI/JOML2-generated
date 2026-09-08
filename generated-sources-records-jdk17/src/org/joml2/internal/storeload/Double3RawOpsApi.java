package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Double3RawOpsApi implements Double3RawOps {
    public Double3 storeUnsafe(Double3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double3 storeFloatUnsafe(Double3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double3 loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
