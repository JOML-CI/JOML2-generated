package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Float2RawOpsApi implements Float2RawOps {
    public Float2 storeUnsafe(Float2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 storeDoubleUnsafe(Float2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
