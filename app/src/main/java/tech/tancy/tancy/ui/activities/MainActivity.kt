package tech.tancy.tancy.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import tech.tancy.tancy.R
import tech.tancy.tancy.databinding.ActivityMainBinding
import tech.tancy.tancy.ui.fragments.ComprasFragment
import tech.tancy.tancy.ui.fragments.PerfilFragment
import tech.tancy.tancy.ui.fragments.ProdutoFragment

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding

    // cria as intancias dos fragmentos
    private val produtoFragment = ProdutoFragment()
    private val comprasFragment = ComprasFragment()
    private val perfilFragment = PerfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonProduto.setOnClickListener(this) // seta o listener do botão de produto
        binding.buttonCompras.setOnClickListener(this) // seta o listener do botão de compras
        binding.buttonPerfil.setOnClickListener(this) // seta o listener do botão de perfil

    }

    // função que troca os fragmentos
    // método responsável por gerenciar a troca de fragmentos
    private fun trocarFragmento(fragmento: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragmento) // e substituir o fragmento atual pelo fragmento passado como parâmetro
            commit()// e por fim, confirmar a transação
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonProduto -> {
                trocarFragmento(produtoFragment)
            }
            R.id.buttonCompras -> {
                trocarFragmento(comprasFragment)
            }
            R.id.buttonPerfil -> {
                trocarFragmento(perfilFragment)
            }
        }
    }

}
