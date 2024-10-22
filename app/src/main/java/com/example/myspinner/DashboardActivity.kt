package com.example.myspinner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myspinner.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.profile.setOnClickListener {
            val intentProfile = Intent(this, ProfileActivity::class.java)
            intentProfile.putExtra("nama", intent.getStringExtra("nama"))
            intentProfile.putExtra("email", intent.getStringExtra("email"))
            intentProfile.putExtra("nomor", intent.getStringExtra("nomor"))
            intentProfile.putExtra("password", intent.getStringExtra("password"))
            startActivity(intentProfile)
        }

        binding.logout.setOnClickListener {
            val intentToLogin = Intent(this, MainActivity::class.java)
            startActivity(intentToLogin)
        }
    }
}