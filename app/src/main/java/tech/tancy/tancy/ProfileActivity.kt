package tech.tancy.tancy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.tancy.tancy.data.ExercisesList
import tech.tancy.tancy.databinding.ActivityExOneBinding
import tech.tancy.tancy.databinding.ActivityExThreeBinding
import tech.tancy.tancy.databinding.ActivityExTwoBinding
import tech.tancy.tancy.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Recupera o email do usuário do sharedPreferences
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val email = sharedPreferences.getString("EMAIL", "")
        val btnLogout = binding.buttonProfileLogout
        binding.textProfileEmail.text = email

        // Botões de exercícios

        binding.btnExOne.setOnClickListener() {
            val intent = Intent(this, ExOneActivity::class.java)
            startActivity(intent)

        }

        binding.btnExTwo.setOnClickListener() {
            val intent = Intent(this, ExTwoActivity::class.java)
            startActivity(intent)

        }

        binding.btnExThree.setOnClickListener() {
            val intent = Intent(this, ExThreeActivity::class.java)
            startActivity(intent)
        }

        // cria um switch case para os botões de exercícios
        // quando clicar no botão, ele vai abrir a activity correspondente

        binding.btnExFour.setOnClickListener() {
            val intent = Intent(this, ExFourActivity::class.java)
            startActivity(intent)
        }

        binding.btnExFive.setOnClickListener() {
            val intent = Intent(this, ExFiveActivity::class.java)
            startActivity(intent)
        }

        binding.btnExSix.setOnClickListener() {
            val intent = Intent(this, ExSixActivity::class.java)
            startActivity(intent)
        }

        binding.btnExSeven.setOnClickListener() {
            val intent = Intent(this, ExSevenActivity::class.java)
            startActivity(intent)
        }

        // função para deslogar o usuário
        fun logout() {
            val editor = sharedPreferences.edit()
            editor.apply {
                putBoolean("LOGGED", false)
            }.apply()
            finish()
        }

        btnLogout.setOnClickListener() {
            logout()
        }


    }

    



}

class ExOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExOneBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExOneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExOne.setOnClickListener() {
            val salario = binding.editExOneSalary.text.toString().toDouble()
            val reajuste = binding.editExOneReajuste.text.toString().toDouble()
            val resultado = String.format("%.2f", ExercisesList.calcularReajuste(salario, reajuste))
            binding.textExOneResult.text = "O valor do reajuste será de R$ $resultado"
        }
    }
}

class ExTwoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityExTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExTwoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExTwo.setOnClickListener() {

            //ExercisesList.calcularVolume()
            val largura = binding.editExTwoLargura.text.toString().toDouble()
            val comprimento = binding.editExTwoComprimento.text.toString().toDouble()
            val altura = binding.editExTwoAltura.text.toString().toDouble()
            val resultado = String.format("%.2f", ExercisesList.calcularVolume(largura, comprimento, altura))
            binding.textExTwoResult.text = "O volume da caixa é de $resultado m³"

        }
    }
}

class ExThreeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityExThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExThreeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExThree.setOnClickListener() {
            // calcual a idade
            val anoNascimento = binding.editExThreeAno.text.toString().toInt()
            val resultado = String.format("%d", ExercisesList.calcularIdade(anoNascimento))
            binding.textExThreeResult.text = "Sua idade é de $resultado anos"

        }
    }
}

class ExFourActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_four)
    }
}

class ExFiveActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_five)
    }
}

class ExSixActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_six)
    }
}

class ExSevenActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_seven)
    }
}





