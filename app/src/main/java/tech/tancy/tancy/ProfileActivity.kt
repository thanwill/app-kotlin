package tech.tancy.tancy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.tancy.tancy.data.ExercisesList
import tech.tancy.tancy.databinding.ActivityExFiveBinding
import tech.tancy.tancy.databinding.ActivityExFourBinding
import tech.tancy.tancy.databinding.ActivityExOneBinding
import tech.tancy.tancy.databinding.ActivityExSevenBinding
import tech.tancy.tancy.databinding.ActivityExSixBinding
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
            val resultado = ExercisesList.calcularReajuste(salario, reajuste)
            binding.textExOneResult.text = "O valor do reajuste será de R$ ${String.format("%.2f",resultado)}. O novo salário será de R$ ${String.format("%.2f", salario + resultado)}."
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
            val resultado = ExercisesList.calcularIdade(anoNascimento)
            binding.textExThreeResult.text = resultado

        }
    }
}

class ExFourActivity : AppCompatActivity(){
    private lateinit var binding: ActivityExFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExFourBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExFour.setOnClickListener() {
            val distancia = binding.editExFourDistancia.text.toString().toDouble()
            val combustivel = binding.editExFourCombustivel.text.toString().toDouble()

            // trata o empty String
            if ( distancia == 0.0 || combustivel == 0.0 ){
                binding.textExFourResult.text = "Digite um valor válido"
                return@setOnClickListener // sai da função
            }else{
                val resultado = String.format("%.2f", ExercisesList.calcularConsumoPorLitro(distancia, combustivel))
                binding.textExFourResult.text = "O consumo por litro é de $resultado km/l"
            }

        }
    }
}

class ExFiveActivity : AppCompatActivity(){
    private lateinit var binding: ActivityExFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExFiveBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExFive.setOnClickListener() {
            val nota1 = binding.editExFiveNota1.text.toString().toDouble()
            val nota2 = binding.editExFiveNota2.text.toString().toDouble()
            val nota3 = binding.editExFiveNota3.text.toString().toDouble()
            val nota4 = binding.editExFiveNota4.text.toString().toDouble()

            // trata o empty String
            if ( nota1 == 0.0 || nota2 == 0.0 || nota3 == 0.0 || nota4 == 0.0 ){
                binding.textExFiveResult.text = "Digite um valor válido"
                return@setOnClickListener // sai da função
            }else{
                val resultado = ExercisesList.calcularMediaFinal(nota1, nota2, nota3, nota4)
                binding.textExFiveResult.text = resultado
            }
        }
    }
}

class ExSixActivity : AppCompatActivity(){
    private lateinit var binding: ActivityExSixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExSixBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExSix.setOnClickListener() {
            val celsius = binding.editExSixCelsius.text.toString().toDouble()
            val resultado = String.format("%.2f", ExercisesList.converterCelsiusParaFahrenheit(celsius))
            binding.textExSixResult.text = "$resultado ºF"
        }
    }
}

class ExSevenActivity : AppCompatActivity(){
    private lateinit var binding: ActivityExSevenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExSevenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExSeven.setOnClickListener() {
            val raio = binding.editExSevenRaio.text.toString().toDouble()
            val altura = binding.editExSevenAltura.text.toString().toDouble()
            val resultado = String.format("%.2f", ExercisesList.calcularVolumeLata(raio, altura))
            binding.textExSevenResult.text = "O volume da lata é de $resultado m³"
        }
    }
}





