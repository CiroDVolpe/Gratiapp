package br.edu.infnet.gratiapp.DBAccess

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.infnet.gratiapp.DAO.FrasesDAO
import br.edu.infnet.gratiapp.models.FrasesModel

@Database (entities = [FrasesModel::class], version = 1)
abstract class DBAccess: RoomDatabase() {

    abstract fun frasesDAO():FrasesDAO

    companion object {
        @Volatile
        private var INSTANCE: DBAccess? = null

        fun getdatabase(context: Context):DBAccess {
            val tempinstance = INSTANCE
            if(tempinstance != null)
                return tempinstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBAccess::class.java,
                    "dbfrases"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}