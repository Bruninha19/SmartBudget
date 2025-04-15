package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityDespesasBinding

class DespesasActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityDespesasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Inicializa o ViewBinding
        binding = ActivityDespesasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agora, você pode acessar os componentes da tela usando o binding
        // Exemplo: binding.tvDespesasTitle.text = "Minha Tela de Despesas"
    }
}
