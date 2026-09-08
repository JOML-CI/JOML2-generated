package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Byte4RawOpsApi implements Byte4RawOps {
    public Byte4 storeUnsafe(Byte4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte4 storeShortUnsafe(Byte4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte4 loadShortUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
