package com.example.myintent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.txtToSignUp.setOnClickListener {
            val intentToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentToMainActivity)
        }

        binding.logIn.setOnClickListener {
            val namaLogIn = binding.namaLogIn.text.toString()
            val passwordLogIn = binding.passwordLogIn.text.toString()

            if (namaLogIn.isEmpty() && passwordLogIn.isEmpty()) {
                Toast.makeText(this, "Please fill form above", Toast.LENGTH_SHORT).show()
            }else {
                if (namaLogIn == intent.getStringExtra("Name") && passwordLogIn == intent.getStringExtra("Password")){
                    val intentToThirdActivity = Intent(this, ThirdActivity::class.java)
                    intentToThirdActivity.putExtra("Namefromlogin", intent.getStringExtra("Name"))
                    intentToThirdActivity.putExtra("Emailfromlogin", intent.getStringExtra("Name"))
                    intentToThirdActivity.putExtra("Nomorfromlogin", intent.getStringExtra("Name"))
                    intentToThirdActivity.putExtra("Passwordfromlogin", intent.getStringExtra("Name"))
                    intentToThirdActivity.putExtra("Kelaminfromlogin", intent.getStringExtra("Kelamin"))
                    startActivity(intentToThirdActivity)
                }else {
                    Toast.makeText(this, "Password or Name is invalid", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}