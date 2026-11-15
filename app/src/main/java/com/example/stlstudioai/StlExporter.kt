package com.example.stlstudioai

import java.io.File
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun saveBinaryStl(file: File, triangles: List<Triangle>) {
    val bufferSize = 80 + 4 + (triangles.size * 50)
    val buffer = ByteBuffer.allocate(bufferSize).order(ByteOrder.LITTLE_ENDIAN)

    buffer.put(ByteArray(80))
    buffer.putInt(triangles.size)

    for (t in triangles) {
        buffer.putFloat(t.normal.x); buffer.putFloat(t.normal.y); buffer.putFloat(t.normal.z)
        buffer.putFloat(t.v1.x); buffer.putFloat(t.v1.y); buffer.putFloat(t.v1.z)
        buffer.putFloat(t.v2.x); buffer.putFloat(t.v2.y); buffer.putFloat(t.v2.z)
        buffer.putFloat(t.v3.x); buffer.putFloat(t.v3.y); buffer.putFloat(t.v3.z)
        buffer.putShort(0)
    }

    file.writeBytes(buffer.array())
}
