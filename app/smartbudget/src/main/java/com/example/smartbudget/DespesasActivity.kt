package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityDespesasBinding
import com.example.smartbudget.database.DatabaseHelper

class DespesasActivity : AppCompatActivity() {


    // Variável para o ViewBinding
    private lateinit var binding: ActivityDespesasBinding
    private lateinit var despesaHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportActionBar?.hide()

        // Inicializa o ViewBinding
        binding = ActivityDespesasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkText: TextView = findViewById<Button>(R.id.adicionarDespesa)

        linkText.setOnClickListener {
            val intent = Intent(this, AdicionarDespesaActivity::class.java) // Substitua com a Activity de destino
            startActivity(intent)
        }

        val linkText2: TextView = findViewById<Button>(R.id.excluirDespesa)

        linkText2.setOnClickListener {
            val intent = Intent(this, ExcluirDespesaActivity::class.java) // Substitua com a Activity de destino
            startActivity(intent)
        }

        despesaHelper = DatabaseHelper(this)
        despesaHelper.buscarDespesas()





        // Agora, você pode acessar os componentes da tela usando o binding
        // Exemplo: binding.tvDespesasTitle.text = "Minha Tela de Despesas"

    }

}