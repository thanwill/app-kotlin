package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.data.LivroAdapter
import tech.tancy.tancy.databinding.ActivityCadastrarBinding
import tech.tancy.tancy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var livroAdapter: LivroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root)

        livroAdapter = LivroAdapter(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = livroAdapter



        binding.button.setOnClickListener {

            var intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        livroAdapter.notifyDataSetChanged()
    }
}

class CadastrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate( layoutInflater )
        setContentView(binding.root)


    }
}

class DetalhesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate( layoutInflater )
        setContentView(binding.root)

    }

}