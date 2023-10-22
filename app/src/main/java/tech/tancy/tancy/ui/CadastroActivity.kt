package tech.tancy.tancy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tech.tancy.tancy.R
import tech.tancy.tancy.data.AppDatabase
import tech.tancy.tancy.data.Convidado
import tech.tancy.tancy.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var id = 0;
    private lateinit var convidado: Convidado
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}