package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityExcluirdespesaBinding

class ExcluirDespesaActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityExcluirdespesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        // Inicializa o ViewBinding
        binding = ActivityExcluirdespesaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
