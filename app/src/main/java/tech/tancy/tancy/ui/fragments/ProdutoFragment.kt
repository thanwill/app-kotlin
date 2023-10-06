package tech.tancy.tancy.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import tech.tancy.tancy.databinding.FragmentProdutoBinding
import tech.tancy.tancy.viewmodel.ProdutoViewModel


class ProdutoFragment : Fragment() {

    private lateinit var binding: FragmentProdutoBinding
    private lateinit var produtoViewModel: ProdutoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment return inflater.inflate(R.layout.fragment_produto, container, false)
        binding = FragmentProdutoBinding.inflate(inflater, container, false)
        val view =  binding.root

        // inicializar a instancia de ProdutoViewModel
        produtoViewModel = ViewModelProvider(this).get(ProdutoViewModel::class.java)
        setObserver()

        // adiciona um toste na tela ao clicar no botão cadastrar
        binding.buttonCadastrarProduto.setOnClickListener {
            val produto = binding.editTextProduto.text.toString()
            val descricao = binding.editTextDescricao.text.toString()
            val preco = binding.editTextNumberPreco.text.toString()
            val quantidade = binding.editTextNumberQuantidade.text.toString()

            // enviar dados dos campos de formulario para a função que será
            // responsavel por tentar efetuar o "cadastro"
            produtoViewModel.cadastrarProduto(produto, descricao, preco, quantidade)

            binding.editTextProduto.text.clear()
            binding.editTextDescricao.text.clear()
            binding.editTextNumberPreco.text.clear()
            binding.editTextNumberQuantidade.text.clear()
        }

        return view
    }

    fun setObserver(){
        // observar o atributo txtToast da Exemplo2ViewModel
        produtoViewModel.getMessageTost().observe(viewLifecycleOwner){
            // exibir um Toast com o valor de txtToast cada vez que houver
            // uma alteração no valor de txtToast dentro de Exemplo2ViewModel
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}