package com.okugata.sintaksys.core.utils

import org.junit.Test

import org.junit.Assert.*

class StringUtilsTest {

    @Test
    fun addPunctuation() {
        val actual = StringUtils.addPunctuation(
            "Hal, sy ogata.",
        "Halo saya okugata"
        )
        val expected = "Halo, saya okugata."
        assertEquals(expected, actual)
    }

    @Test
    fun addColor() {
        val actual = StringUtils.addColor(
            "Hal, sy ogata.",
            "Halo saya okugata"
        )
        val expected = "Halo, saya okugata."
        assertEquals(expected, actual)
    }
}