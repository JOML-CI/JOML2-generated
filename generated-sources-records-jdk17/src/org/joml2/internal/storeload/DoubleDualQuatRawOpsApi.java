package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleDualQuatRawOpsApi implements DoubleDualQuatRawOps {
    public DoubleDualQuat storeUnsafe(DoubleDualQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat storeFloatUnsafe(DoubleDualQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
