package com.example.smartbudget

import DespesaRepository
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityAdicionardespesaBinding
import com.google.android.material.snackbar.Snackbar

class AdicionarDespesaActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityAdicionardespesaBinding
    private lateinit var repository: DespesaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = DespesaRepository(this)

        supportActionBar?.hide()
        // Inicializa o ViewBinding
        binding = ActivityAdicionardespesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvarDespesa.setOnClickListener {
            val nomeDespesa = binding.inputNomeDespesa.text.toString()
            val valorDespesa = binding.inputValorDespesa.text.toString().toDouble()

            try {
                repository.inserir(nomeDespesa, valorDespesa, "")
                Snackbar.make(binding.root, "Salvo com sucesso !", Snackbar.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Errooo", Snackbar.LENGTH_SHORT).show()
                Log.e("DB_ERROR", e.message?:"sem erro")
            }
        }

    }
}
