package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class Float2RawOpsApi implements Float2RawOps {
    public Float2 storeUnsafe(Float2Impl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 loadUnsafe(Float2Impl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 storeDoubleUnsafe(Float2Impl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Float2 loadDoubleUnsafe(Float2Impl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
