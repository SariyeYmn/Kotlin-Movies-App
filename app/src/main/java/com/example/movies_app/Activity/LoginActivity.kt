package com.example.movies_app.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityIntroBinding
import com.example.movies_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private  val userName = "Sare"
    private  val password = "Sare"

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            val gUserName = binding.userNameEdit.text.toString()
            val gPassword = binding.passwordEdit.text.toString()
            if (gUserName == userName && gPassword == password){
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Giriş bilgileriniz hatalı.Tekrar deneyiniz", Toast.LENGTH_SHORT).show()
            }
        }
    }
}