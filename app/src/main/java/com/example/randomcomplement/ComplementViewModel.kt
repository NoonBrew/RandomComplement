package com.example.randomcomplement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ComplementViewModel: ViewModel() {

    private val complementRepository = ComplementRepository()
    var complementText = "" // Holds the value from the API

    fun getComplement() {
        viewModelScope.launch {
            val apiResult = complementRepository.getComplement()
            complementText = apiResult.text
        }
    }
}