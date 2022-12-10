package br.edu.infnet.gratiapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import br.edu.infnet.gratiapp.databinding.ActivityMainBinding
import br.edu.infnet.gratiapp.repository.GratiRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: GratiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()

    }

    private fun setup() {
        repository = GratiRepository.get()
        setupViews()
        setupClickListeners()    }

    private fun setupClickListeners() {
        binding.btnLogout.setOnClickListener {
            repository.logout()
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun setupViews() {
        setTitle("Principal")
        binding.tvWelcome.text = "Olá, ${repository.getCurrentUser()?.email}"
    }
}


