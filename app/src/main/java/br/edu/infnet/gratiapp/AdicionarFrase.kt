package br.edu.infnet.gratiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.gratiapp.databinding.ActivityAdicionarFraseBinding
import br.edu.infnet.gratiapp.databinding.ActivityMainBinding

class AdicionarFrase : AppCompatActivity() {

    private val binding by lazy{
        ActivityAdicionarFraseBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}