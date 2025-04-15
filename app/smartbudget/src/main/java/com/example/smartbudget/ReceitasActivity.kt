package com.example.smartbudget

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityReceitasBinding

class ReceitasActivity : AppCompatActivity() {

    // Variável para o ViewBinding
    private lateinit var binding: ActivityReceitasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        fun VoltarAoClicar(view: View) {
            // Ação ao clicar, tipo:
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // ou ir pra outra activity
        }

        // Inicializa o ViewBinding
        binding = ActivityReceitasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agora, você pode acessar os componentes da tela usando o binding
        // Exemplo: binding.tvReceitasTitle.text = "Minha Tela de Receitas"
    }
}
