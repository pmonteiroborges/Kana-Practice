package com.example.myrealkana.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudyViewModelFactory(private val arguments: StudyFragmentArgs): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudyViewModel::class.java)) {
            return StudyViewModel(arguments) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}