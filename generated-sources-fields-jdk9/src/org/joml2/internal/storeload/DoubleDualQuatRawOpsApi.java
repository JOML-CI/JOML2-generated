package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class DoubleDualQuatRawOpsApi implements DoubleDualQuatRawOps {
    public DoubleDualQuat storeUnsafe(DoubleDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat loadUnsafe(DoubleDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat storeFloatUnsafe(DoubleDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleDualQuat loadFloatUnsafe(DoubleDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
