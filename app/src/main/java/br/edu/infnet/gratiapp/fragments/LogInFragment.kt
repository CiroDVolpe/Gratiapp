package br.edu.infnet.gratiapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.infnet.gratiapp.MainActivity
import br.edu.infnet.gratiapp.R
import br.edu.infnet.gratiapp.databinding.FragmentLogInBinding
import br.edu.infnet.gratiapp.viewmodel.LoginViewModel

class LogInFragment : Fragment() {

    val viewModel by activityViewModels<LoginViewModel>()

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        val view = binding?.root
        setup()
        return view
    }

    private fun setup() {
        setupView()
        setupClickListeners()
    }

    private fun setupView() {
        activity?.setTitle("Autenticar")
    }
    private fun setupClickListeners() {
        binding?.apply {
            btnSignIn.setOnClickListener {
                onSignInClick()
            }
            btnSignOn.setOnClickListener {
                onSignOnClick()
            }
        }
    }

    private fun onSignOnClick() {
        findNavController().navigate(R.id.action_logInFragment_to_signOnFragment)
    }

    private fun onSignInClick() {
        val email = binding?.inputEmail?.text.toString()
        val password = binding?.inputPassword?.text.toString()
        signIn(email, password)
    }

    private fun signIn(email: String, password: String) {
        viewModel.login(email, password)
            .addOnSuccessListener {
                Toast.makeText(
                    requireContext(),
                    "Autenticado com sucesso.",
                    Toast.LENGTH_SHORT
                ).show()
                startMainActivity()
            }
            .addOnFailureListener {
                Toast.makeText(
                    requireContext(),
                    "Falha na autenticação.",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    fun startMainActivity(){
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}