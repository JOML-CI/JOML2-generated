package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Float3RawOpsApi implements Float3RawOps {
    public Float3 storeUnsafe(Float3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float3 storeDoubleUnsafe(Float3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float3 loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
