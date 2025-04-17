package com.example.smartbudget

import ReceitaRepository
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityAdicionarreceitaBinding
import com.google.android.material.snackbar.Snackbar

class AdicionarReceitaActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityAdicionarreceitaBinding
    private lateinit var repository: ReceitaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = ReceitaRepository(this)

        supportActionBar?.hide()
        // Inicializa o ViewBinding
        binding = ActivityAdicionarreceitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvarReceita.setOnClickListener {
            val nomeReceita = binding.inputNomeReceita.text.toString()
            val valorReceita = binding.inputValorReceita.text.toString().toDouble()

            try {
                repository.inserir(nomeReceita, valorReceita, "")
                Snackbar.make(binding.root, "Salvo com sucesso !", Snackbar.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Errooo", Snackbar.LENGTH_SHORT).show()
                Log.e("DB_ERROR", e.message?:"sem erro")
            }
        }
    }
}