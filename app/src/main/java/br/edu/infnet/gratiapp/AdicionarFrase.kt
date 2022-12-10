package br.edu.infnet.gratiapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import br.edu.infnet.gratiapp.DBAccess.DBAccess
import br.edu.infnet.gratiapp.databinding.ActivityAdicionarFraseBinding
import br.edu.infnet.gratiapp.models.FrasesModel
import com.google.firebase.auth.FirebaseAuth
import com.google.type.DateTime

class AdicionarFrase : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarFraseBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnAddFrase.setOnClickListener {
            val db = DBAccess.getdatabase(this)
            val dao = db.frasesDAO()
            val frase = FrasesModel(
                phrase = binding.editFrase.text.toString(),
                create_at = DateTime.getDefaultInstance(),
                user_id = FirebaseAuth.getInstance().currentUser!!.uid
            )
            dao.insertall(frase)
        }


    }
}