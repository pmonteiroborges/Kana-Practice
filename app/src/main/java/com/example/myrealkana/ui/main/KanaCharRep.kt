package com.example.myrealkana.ui.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KanaCharRep(val representation: String, val isHiragana: Boolean, var isSelected: Boolean = false): Parcelable {
    override fun hashCode(): Int {
        return representation.hashCode() * 3 + isHiragana.hashCode() * 5
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KanaCharRep

        if (representation != other.representation) return false
        if (isHiragana != other.isHiragana) return false

        return true
    }
}