package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Float4RawOpsApi implements Float4RawOps {
    public Float4 storeUnsafe(Float4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float4 storeDoubleUnsafe(Float4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float4 loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
