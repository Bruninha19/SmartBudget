package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityReceitasBinding

class ReceitasActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityReceitasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportActionBar?.hide()

        // Inicializa o ViewBinding
        binding = ActivityReceitasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkText: TextView = findViewById<Button>(R.id.adicionarReceita)

        linkText.setOnClickListener {
            val intent = Intent(this, AdicionarReceitaActivity::class.java) // Substitua com a Activity de destino
            startActivity(intent)
        }

        val linkText2: TextView = findViewById<Button>(R.id.excluirReceita)

        linkText2.setOnClickListener {
            val intent = Intent(this, ExcluirReceitaActivity::class.java) // Substitua com a Activity de destino
            startActivity(intent)
        }

        // Agora, você pode acessar os componentes da tela usando o binding
        // Exemplo: binding.tvReceitasTitle.text = "Minha Tela de Receitas"
    }
}
