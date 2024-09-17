package com.example.myintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val signUp = binding.signUp
        var selectedValue: String? = null


        signUp.setOnClickListener {
            val nama = binding.nama.text.toString()
            val email = binding.email.text.toString()
            val nomor = binding.nomor.text.toString()
            val password = binding.password.text.toString()
//            var radioGroup = findViewById<RadioGroup>(R.id.kelamin)
//            var selectedRadioButtonId = radioGroup.checkedRadioButtonId
//            if (selectedRadioButtonId != -1) {
//                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
//                selectedValue = selectedRadioButton.text.toString()
//            }else{
//                Toast.makeText(this, "Please fill the gender", Toast.LENGTH_SHORT).show()
//            }

            val laki = binding.Laki
            val perempuan = binding.Perempuan
            var kelamin = false

            if (laki.isChecked) {
                selectedValue = laki.text.toString()
                kelamin = true
            }else if (perempuan.isChecked) {
                selectedValue = perempuan.text.toString()
                kelamin = true
            } else if (!laki.isActivated && !perempuan.isActivated) {
                Toast.makeText(this, "Please fill gender type", Toast.LENGTH_SHORT).show()
            }

            if (kelamin == true && nama.isNotEmpty() && email.isNotEmpty() && nomor.isNotEmpty() && password.isNotEmpty()) {
                val intentToSecondActivity = Intent(this, SecondActivity::class.java)
                intentToSecondActivity.putExtra("Name", nama)
                intentToSecondActivity.putExtra("Email", email)
                intentToSecondActivity.putExtra("Nomor", nomor)
                intentToSecondActivity.putExtra("Password", password)
                intentToSecondActivity.putExtra("Kelamin", selectedValue)
                startActivity(intentToSecondActivity)
            }else {
                Toast.makeText(this, "Please fill form above", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtToLogIn.setOnClickListener {
            val intentToLogIn = Intent(this, SecondActivity::class.java)
            startActivity(intentToLogIn)
        }


    }
}