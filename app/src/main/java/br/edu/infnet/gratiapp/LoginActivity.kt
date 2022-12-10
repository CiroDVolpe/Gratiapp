package br.edu.infnet.gratiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import br.edu.infnet.gratiapp.databinding.ActivityLoginBinding
import br.edu.infnet.gratiapp.viewmodel.LoginViewModel
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginActivity : AppCompatActivity() {

    val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val toolbar = supportActionBar!!
//        toolbar.title = "GratiApp"
    }

    override fun onStart() {
        super.onStart()
        if(viewModel.isLoggedIn()){
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
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
        startActivity(Intent(this,LoginActivity::class.java))
        this.finishAffinity()
    }
}