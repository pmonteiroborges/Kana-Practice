package com.example.myrealkana.ui.main

data class KanaChar(val readings: List<String>, val isHiragana: Boolean) {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KanaChar

        if (readings != other.readings) return false
        if (isHiragana != other.isHiragana) return false

        return true
    }
}