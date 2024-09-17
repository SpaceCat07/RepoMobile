package com.example.myintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myintent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.namaTampil.text = binding.namaTampil.text.toString() + intent.getStringExtra("Namefromlogin")
        binding.emailTampil.text = binding.emailTampil.text.toString() + intent.getStringExtra("Emailfromlogin")
        binding.nomorTampil.text = binding.nomorTampil.text.toString() + intent.getStringExtra("Nomorfromlogin")
        binding.passwordTampil.text = binding.passwordTampil.text.toString() + intent.getStringExtra("Passwordfromlogin")
        binding.kelaminTampil.text = binding.kelaminTampil.text.toString() + intent.getStringExtra("Kelaminfromlogin")

        binding.logout.setOnClickListener {
            val intentBackToSecond = Intent(this, SecondActivity::class.java)
            startActivity(intentBackToSecond)
            super.onDestroy()
        }
    }
}