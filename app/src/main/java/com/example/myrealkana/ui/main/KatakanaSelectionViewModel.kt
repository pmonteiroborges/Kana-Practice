package com.example.myrealkana.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KatakanaSelectionViewModel : ViewModel() {
    val kanaMap = hashMapOf(
        KanaCharRep("a", false) to MutableLiveData<Boolean>(),
        KanaCharRep("k", false) to MutableLiveData<Boolean>(),
        KanaCharRep("s", false) to MutableLiveData<Boolean>(),
        KanaCharRep("t", false) to MutableLiveData<Boolean>(),
        KanaCharRep("n", false) to MutableLiveData<Boolean>(),
        KanaCharRep("h", false) to MutableLiveData<Boolean>(),
        KanaCharRep("m", false) to MutableLiveData<Boolean>(),
        KanaCharRep("r", false) to MutableLiveData<Boolean>(),
        KanaCharRep("y", false) to MutableLiveData<Boolean>(),
        KanaCharRep("w", false) to MutableLiveData<Boolean>(),
        KanaCharRep("N", false) to MutableLiveData<Boolean>(),
        KanaCharRep("g", false) to MutableLiveData<Boolean>(),
        KanaCharRep("z", false) to MutableLiveData<Boolean>(),
        KanaCharRep("d", false) to MutableLiveData<Boolean>(),
        KanaCharRep("b", false) to MutableLiveData<Boolean>(),
        KanaCharRep("p", false) to MutableLiveData<Boolean>()
    )

    private var _navigateToScoreFragment = MutableLiveData<Boolean>()
    val navigateToScoreFactor: LiveData<Boolean>
        get() = _navigateToScoreFragment

    init {
        for ((_, value) in kanaMap) {
            value.value = false
        }

        _navigateToScoreFragment.value = false
    }

    fun onCharClicked(rep: KanaCharRep) {
        kanaMap[rep]?.value = !kanaMap[rep]!!.value!!

    }

    fun onSelectAllClicked() {
        for ((_, value) in kanaMap) {
            value.value = true
        }
    }

    fun onClearAllClicked() {
        for ((_, value) in kanaMap) {
            value.value = false
        }
    }

    fun onNextButtonClicked() {
        _navigateToScoreFragment.value = true
    }

    fun onNavigationDone() {
        _navigateToScoreFragment.value = false
    }
}