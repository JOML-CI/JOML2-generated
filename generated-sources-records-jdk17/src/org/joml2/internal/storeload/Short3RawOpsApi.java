package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Short3RawOpsApi implements Short3RawOps {
    public Short3 storeUnsafe(Short3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short3 storeByteUnsafe(Short3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short3 loadByteUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
