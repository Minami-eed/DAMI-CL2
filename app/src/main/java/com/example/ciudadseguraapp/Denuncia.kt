package com.example.ciudadseguraapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Denuncia.TABLE_NAME)
data class Denuncia (
    @ColumnInfo(name="lugar_denuncia")
    val lugar: String,
    @ColumnInfo(name="titulo_denuncia")
    val titulo: String ,
    @ColumnInfo(name="fecha_denuncia")
    val fecha: String,
    @ColumnInfo(name="descripcion_denuncia")
    val descripcion: String ) {

    companion object{
        const val TABLE_NAME ="denuncias_table"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="denuncia_id")
    var denunciaID: Int = 0
}