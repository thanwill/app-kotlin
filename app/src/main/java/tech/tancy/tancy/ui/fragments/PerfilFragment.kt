package tech.tancy.tancy.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tech.tancy.tancy.R
import tech.tancy.tancy.databinding.FragmentPerfilBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class PerfilFragment : Fragment() {

    // Função que cria a activity do fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
    ): View? {
        return inflater.inflate(R.layout.fragment_perfil, container, false) // Infla o layout do fragmento
    }

}