package br.edu.infnet.gratiapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.type.DateTime

@Entity(tableName = "frases")
data class FrasesModel(
    @PrimaryKey(autoGenerate = true) val id:Long = 0,
    @ColumnInfo(name = "Phrase") var phrase: String,
    @ColumnInfo(name = "Create_at") var create_at: DateTime,
    @ColumnInfo(name = "User_id") var user_id: String = "",

)
