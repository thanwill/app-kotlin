package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import tech.tancy.tancy.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val funcionario = intent.getStringExtra("funcionario")
        val textViewNome = binding.textViewNome
        val textViewCargo = binding.textViewCargo
        val textViewSalario = binding.textViewSalario
        val textViewAbono = binding.textViewAbono


    }
}