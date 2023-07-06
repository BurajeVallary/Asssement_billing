package dev.`val`.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import dev.`val`.assignment.databinding.ActivityMainBinding

import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etButton.setOnClickListener {
           val intent = Intent(this,login::class.java)
            startActivity(intent)
            validateSignUp()
        }

        clearErrorOnType()
    }

    private fun validateSignUp() {
        val name = binding.etusername.text.toString()
        val email = binding.etemail.text.toString()
        val phone = binding.etphonenumber.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.tiluser.error = "Name is required"
            error = true
        } else {
            binding.tiluser.error = null
        }
        if (name.isBlank()) {
            binding.tilPassword.error = "Name is required"
            error = true
        } else {
            binding.tilPassword.error = null
        }


        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        } else {
            binding.tilEmail.error = null
        }


        if (phone.isEmpty()) {
            binding.tilphone.error = "Phone Number is required"
            error = true
        } else {
            binding.tilphone.error = null
        }


        if (!error) {
            Toast.makeText(this,"congratulations", Toast.LENGTH_LONG).show()
        }
    }

    private fun clearErrorOnType() {
        binding.tiluser.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tiluser.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.tilphone.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilphone.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.tilEmail.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
