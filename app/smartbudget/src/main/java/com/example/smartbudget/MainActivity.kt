package com.example.smartbudget



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smartbudget.databinding.ActivityMainBinding  // Altere conforme o nome do seu layout.

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDespesas = findViewById<Button>(R.id.btnDespesas)
        val btnReceitas = findViewById<Button>(R.id.btnReceitas)

        // Navegação para a tela de Despesas
        btnDespesas.setOnClickListener {
            val intent = Intent(this, DespesasActivity::class.java)
            startActivity(intent)
        }

        // Navegação para a tela de Receitas
        btnReceitas.setOnClickListener {
            val intent = Intent(this, ReceitasActivity::class.java)
            startActivity(intent)
        }
    }
}
