package tech.tancy.tancy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.data.CompromissoAdapter
import tech.tancy.tancy.databinding.ActivityAppBinding
import tech.tancy.tancy.databinding.FragmentListaBinding

class PerfilFragment : Fragment() {


    // Função que cria a activity do fragmento
    // ativa o biding para o fragmento
    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
    ): View? {
        return inflater.inflate(R.layout.fragment_perfil, container, false) // Infla o layout do fragmento
    }

    companion object {

    }
}

// cria o fragmento lista
class ListaFragment : Fragment() {
    private lateinit var compromissoAdapter: CompromissoAdapter
    private lateinit var binding: FragmentListaBinding
    // Função que cria a activity do fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false) // Infla o layout do fragmento
    }

    companion object {

    }
}

// cria o fragmento cadastro
class CadastroFragment : Fragment() {

    // Função que cria a activity do fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastro, container, false) // Infla o layout do fragmento
    }

    companion object {

    }
}

class DetalhesFragment : Fragment(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle? // Bundle é um objeto que contém um conjunto de pares chave/valor que podem ser usados para armazenar dados primitivos
        ): View? {
            return inflater.inflate(R.layout.fragment_detalhes, container, false) // Infla o layout do fragmento
        }

        companion object {

        }
}