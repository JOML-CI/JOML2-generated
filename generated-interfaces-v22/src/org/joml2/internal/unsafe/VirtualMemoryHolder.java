package org.joml2.internal.unsafe;

import java.lang.foreign.MemorySegment;

public final class VirtualMemoryHolder {
    private VirtualMemoryHolder() {}
    public static final MemorySegment VIRTUAL_MEMORY =
            MemorySegment.ofAddress(0L).reinterpret(Long.MAX_VALUE);
}
