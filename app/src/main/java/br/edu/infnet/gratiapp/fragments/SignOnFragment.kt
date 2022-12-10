package br.edu.infnet.gratiapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import br.edu.infnet.gratiapp.MainActivity
import br.edu.infnet.gratiapp.databinding.FragmentSignOnBinding
import br.edu.infnet.gratiapp.viewmodel.LoginViewModel

class SignOnFragment : Fragment() {
    val viewModel by activityViewModels<LoginViewModel>()
    private var _binding: FragmentSignOnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignOnBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view

    }

    private fun setup() {
        setupView()
        setupClickListeners()

    }

    private fun setupClickListeners() {
        binding.apply {
            btnSignOn.setOnClickListener {
                onSignOnClick()
            }
        }
    }

    private fun onSignOnClick() {
        binding.apply {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            val confirmPassword = inputConfirmPassword.text.toString()
            if( (password == confirmPassword) && password.length > 5){
                signOn(email, password)
            }
        }
    }

    private fun signOn(email: String, password: String) {
        viewModel.signOn(email, password)
            .addOnSuccessListener {
                Toast.makeText(
                    requireContext(),
                    "Cadastro com sucesso.",
                    Toast.LENGTH_SHORT
                ).show()
                startMainActivity()
            }
            .addOnFailureListener{
                Toast.makeText(
                    requireContext(),
                    "Falha ao cadastrar",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    fun startMainActivity(){
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finish()
    }

    private fun setupView() {
        activity?.setTitle("Cadastro")
    }

}