package com.example.ciudadseguraapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Denuncia:: class], version = 1 )
abstract class DenunciaDataBase : RoomDatabase() {

    abstract fun denunciaDAO(): DenunciaDao

    companion object{
        private const val  DATABASE_NAME = "denuncia_database"
        @Volatile
        private var INSTANCE: DenunciaDataBase? = null

        fun getInstance(context: Context) : DenunciaDataBase?{
            INSTANCE
                ?: synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DenunciaDataBase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            return  INSTANCE
        }
    }
}