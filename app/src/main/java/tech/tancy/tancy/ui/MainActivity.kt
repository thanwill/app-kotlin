package tech.tancy.tancy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import tech.tancy.tancy.R
import tech.tancy.tancy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    // função que troca os fragmentos
    // método responsável por gerenciar a troca de fragmentos
    private fun trocarFragmento(fragmento: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragmento) // e substituir o fragmento atual pelo fragmento passado como parâmetro
            commit()// e por fim, confirmar a transação
        }
    }


}
