package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        fun logout(){
            val editor = sharedPreferences.edit()
            editor.apply{
                putBoolean("LOGGED", false)
            }.apply()
            finish()
        }

        binding.buttonProfileLogout.setOnClickListener(){
            logout()
        }

        binding.textProfileEmail.text = email
    }




}