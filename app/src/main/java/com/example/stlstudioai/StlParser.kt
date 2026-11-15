package com.example.stlstudioai

import java.io.File
import java.nio.ByteBuffer
import java.nio.ByteOrder

data class Vector3(val x: Float, val y: Float, val z: Float)
data class Triangle(val normal: Vector3, val v1: Vector3, val v2: Vector3, val v3: Vector3)

fun parseBinaryStl(file: File): List<Triangle> {
    val bytes = file.readBytes()
    val buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
    
    buffer.position(80)
    val numTriangles = buffer.int
    val triangles = mutableListOf<Triangle>()
    
    for (i in 0 until numTriangles) {
        val normal = Vector3(buffer.float, buffer.float, buffer.float)
        val v1 = Vector3(buffer.float, buffer.float, buffer.float)
        val v2 = Vector3(buffer.float, buffer.float, buffer.float)
        val v3 = Vector3(buffer.float, buffer.float, buffer.float)
        buffer.short
        triangles.add(Triangle(normal, v1, v2, v3))
    }
    return triangles
}
