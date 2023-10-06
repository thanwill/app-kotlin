package tech.tancy.tancy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.tancy.tancy.databinding.FragmentPerfilBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    // Função que cria a activity do fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

}