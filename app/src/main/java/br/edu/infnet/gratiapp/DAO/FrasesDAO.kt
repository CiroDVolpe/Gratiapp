package br.edu.infnet.gratiapp.DAO

import androidx.room.*
import br.edu.infnet.gratiapp.models.FrasesModel

@Dao
interface FrasesDAO {

    @Query("SELECT * FROM frases")
    fun getall():MutableList<FrasesModel>

    @Insert
    fun insertall(vararg frasesModel: FrasesModel)

    @Query("DELETE FROM frases WHERE id=:id")
    fun delete(id:Long)

    @Update
    suspend fun updatephrase(frase:FrasesModel)
}