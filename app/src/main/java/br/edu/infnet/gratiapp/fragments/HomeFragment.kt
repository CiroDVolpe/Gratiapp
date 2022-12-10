package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.gratiapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
//            btnFrases.setOnClickListener{
//                /// Colocamos aqui o acesso ao modulo de frases.
//            }
        }
    }

    private fun setupViews() {
        activity?.setTitle("Principal")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}