package com.example.ciudadseguraapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DenunciaDao {
    @Insert
    fun insert(denuncia: Denuncia)

    @Query("SELECT * FROM " + Denuncia.TABLE_NAME +" ORDER BY fecha_denuncia DESC")
    fun list(): LiveData<List<Denuncia>>
}