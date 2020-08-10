package com.example.myrealkana.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HiraganaSelectionViewModel : ViewModel() {
    val kanaMap = hashMapOf(
        KanaCharRep("a", true) to MutableLiveData<Boolean>(),
        KanaCharRep("k", true) to MutableLiveData<Boolean>(),
        KanaCharRep("s", true) to MutableLiveData<Boolean>(),
        KanaCharRep("t", true) to MutableLiveData<Boolean>(),
        KanaCharRep("n", true) to MutableLiveData<Boolean>(),
        KanaCharRep("h", true) to MutableLiveData<Boolean>(),
        KanaCharRep("m", true) to MutableLiveData<Boolean>(),
        KanaCharRep("r", true) to MutableLiveData<Boolean>(),
        KanaCharRep("y", true) to MutableLiveData<Boolean>(),
        KanaCharRep("w", true) to MutableLiveData<Boolean>(),
        KanaCharRep("N", true) to MutableLiveData<Boolean>(),
        KanaCharRep("g", true) to MutableLiveData<Boolean>(),
        KanaCharRep("z", true) to MutableLiveData<Boolean>(),
        KanaCharRep("d", true) to MutableLiveData<Boolean>(),
        KanaCharRep("b", true) to MutableLiveData<Boolean>(),
        KanaCharRep("p", true) to MutableLiveData<Boolean>()
    )

    private var _hiraTrueKataFalse = MutableLiveData<Boolean>()
    val hiraTrueKataFalse: LiveData<Boolean>
        get() = _hiraTrueKataFalse
    
    private var _navigateToKatakanaFrag = MutableLiveData<Boolean>()
    val navigateToKatakanaFrag: LiveData<Boolean>
        get() = _navigateToKatakanaFrag

    init {
        for ((_, value) in kanaMap) {
            value.value = false
        }
        
        _hiraTrueKataFalse.value = true
        _navigateToKatakanaFrag.value = false
    }

    fun onCharClicked(rep: KanaCharRep) {
        kanaMap[rep]!!.value = !kanaMap[rep]!!.value!!

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
        _navigateToKatakanaFrag.value = true
    }

    fun onNavigationDone() {
        _navigateToKatakanaFrag.value = false
    }
}