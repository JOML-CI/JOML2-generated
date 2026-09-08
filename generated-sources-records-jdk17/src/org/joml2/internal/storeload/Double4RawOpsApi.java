package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Double4RawOpsApi implements Double4RawOps {
    public Double4 storeUnsafe(Double4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double4 storeFloatUnsafe(Double4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double4 loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
