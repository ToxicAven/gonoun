package dev.toxicaven.gonoun.util

import java.awt.Color
import kotlin.random.Random
import kotlin.random.nextInt


class RandomColor {
    fun get(): Color {
        return Color(Random.nextInt(30..255), Random.nextInt(30..255), Random.nextInt(30..255))
    }
}