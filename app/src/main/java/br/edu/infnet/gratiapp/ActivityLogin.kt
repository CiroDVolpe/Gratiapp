package br.edu.infnet.gratiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.gratiapp.databinding.ActivityAdicionarFraseBinding
import br.edu.infnet.gratiapp.databinding.ActivityLoginBinding

class ActivityLogin : AppCompatActivity() {

    private val binding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}