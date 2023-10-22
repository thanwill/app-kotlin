package tech.tancy.tancy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.R
import tech.tancy.tancy.databinding.ActivityMainBinding
import tech.tancy.tancy.ui.viewholder.ConvidadosAdapter
import tech.tancy.tancy.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptar : ConvidadosAdapter
    private lateinit var viewModel : MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializa o adapter
        adaptar = ConvidadosAdapter(this)

        // inicializa o viewmodel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // inicializa o recyclerview
        binding.listaConvidados.layoutManager= LinearLayoutManager(this)

        setObservers()
        setAdapter()

        binding.buttonCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }


    }

    fun setObservers(){
        viewModel.getConvidados().observe(this) {
            adaptar.atualizaLista(it)
        }
    }

    fun setAdapter(){
        binding.listaConvidados.adapter = adaptar
    }

    override fun onResume() {
        super.onResume()
        setObservers()
        setAdapter()
    }


}
