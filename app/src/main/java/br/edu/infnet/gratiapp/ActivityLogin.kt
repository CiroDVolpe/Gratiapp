package br.edu.infnet.gratiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.edu.infnet.gratiapp.databinding.ActivityAdicionarFraseBinding
import br.edu.infnet.gratiapp.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class ActivityLogin : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar = supportActionBar!!
        toolbar.title = "GratiApp"


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId) {
           R.id.logout -> firebaselogout()
       }
        return true
    }

    private fun firebaselogout() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this,ActivityLogin::class.java))
        this.finishAffinity()
    }

    private fun logarUsuario(email: String, senha: String) {

        auth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }.addOnFailureListener {
                when (it) {
                    is FirebaseAuthInvalidCredentialsException -> Toast.makeText(
                        this,
                        "Usuário ou senha incorretos",
                        Toast.LENGTH_SHORT
                    ).show()

                    is FirebaseNetworkException -> Toast.makeText(
                        this,
                        "Erro na conexão",
                        Toast.LENGTH_SHORT
                    ).show()

                    else -> Toast.makeText(
                        this,
                        "Erro desconhecido",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}