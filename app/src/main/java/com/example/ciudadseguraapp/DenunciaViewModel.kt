package com.example.ciudadseguraapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DenunciaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository= DenunciaRepository(application)
    val denuncias = repository.getDenuncias()

    fun saveDenunciaWithCoroutines(denuncia: Denuncia){
        viewModelScope.launch {
            repository.insertDenunciaWithCoroutine(denuncia)
        }
    }
}