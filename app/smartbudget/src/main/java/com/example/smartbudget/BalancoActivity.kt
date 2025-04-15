package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityBalancofinanceiroBinding

class BalancoActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityBalancofinanceiroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        // Inicializa o ViewBinding
        binding = ActivityBalancofinanceiroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agora, você pode acessar os componentes da tela usando o binding
        // Exemplo: binding.tvDespesasTitle.text = "Minha Tela de Despesas"
    }
}
