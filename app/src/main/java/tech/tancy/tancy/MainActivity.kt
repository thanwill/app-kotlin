package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import tech.tancy.tancy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val auth = FirebaseAuth.getInstance() // instancia o firebase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)
        setContentView(view) // seta o conteúdo da tela com o binding

        val btnLogin = binding.buttonLogin
        val btnRegister = binding.textNewRegister

        fun login(){
            val email = binding.editLoginEmail.text.toString()
            val password = binding.editLoginPassword.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, ProfileActivity::class.java)
                        startActivity(intent)

                        // Salva o email do usuário no sharedPreferences
                        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.apply{
                            putString("EMAIL", email)
                            putBoolean("LOGGED", true)
                        }.apply()

                        Toast.makeText(baseContext, "Login realizado com sucesso.",
                            Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(baseContext, "Falha na autenticação.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        btnLogin.setOnClickListener(){
            login()
        }

        // direciona para a main de cadastro ao clicar em btnRegister
        btnRegister.setOnClickListener(){
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }





    }


}