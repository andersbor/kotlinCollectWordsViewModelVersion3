package com.example.collectwordsviewmodelversion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordsViewModel : ViewModel() {
    private var _words: MutableList<String> = mutableListOf<String>()
    private var mutableLiveData: MutableLiveData<List<String>> = MutableLiveData()

    // Immutable access to list of words:
    // Clients are not allowed to replace the full list
    val words: LiveData<List<String>> = mutableLiveData

    fun add(newWord: String) {
        _words.add(newWord)
        mutableLiveData.value = _words // notifies observers
    }

    fun clear() {
        _words.clear()
        mutableLiveData.value = _words
    }

    operator fun get(position: Int): String { // [] operator overloading
        return _words[position]
    }

    fun remove(position: Int) {
        _words.removeAt(position)
        mutableLiveData.value = _words
    }

}