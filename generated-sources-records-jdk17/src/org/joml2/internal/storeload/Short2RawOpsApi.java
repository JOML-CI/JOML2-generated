package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Short2RawOpsApi implements Short2RawOps {
    public Short2 storeUnsafe(Short2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short2 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short2 storeByteUnsafe(Short2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short2 loadByteUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
