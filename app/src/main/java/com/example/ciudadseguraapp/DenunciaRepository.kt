package com.example.ciudadseguraapp

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DenunciaRepository(application: Application) {
    private val denunciaDAO: DenunciaDao? =
        DenunciaDataBase.getInstance(application)?.denunciaDAO()

    suspend fun insertDenunciaWithCoroutine(denuncia : Denuncia){
        processInsertNote(denuncia)
    }

    private suspend fun processInsertNote (denuncia :Denuncia){
        withContext(Dispatchers.Default){
            denunciaDAO?.insert(denuncia)
        }
    }

    fun getDenuncias(): LiveData<List<Denuncia>>?{
        return denunciaDAO?.list();
    }
}