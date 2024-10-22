package com.example.myspinner

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myspinner.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = arguments?.getString("nama")
        val password = arguments?.getString("password")
        val nomor = arguments?.getString("hp")
        val email = arguments?.getString("email")

        with(binding) {
            logIn.setOnClickListener {
                if (binding.namaLogIn.text.toString().isEmpty() || binding.passwordLogIn.text.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Nama dan Password tidak dapat kosong", Toast.LENGTH_SHORT).show()
                } else if (binding.namaLogIn.text.toString() != nama || binding.passwordLogIn.text.toString() != password) {
                    Toast.makeText(requireContext(), "Nama atau Password salah", Toast.LENGTH_SHORT).show()
                } else {
                    val intentDashboardActivity = Intent(activity, DashboardActivity::class.java)
                    intentDashboardActivity.putExtra("nama", nama)
                    intentDashboardActivity.putExtra("password", password)
                    intentDashboardActivity.putExtra("email", email)
                    intentDashboardActivity.putExtra("nomor", nomor)
                    startActivity(intentDashboardActivity)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}