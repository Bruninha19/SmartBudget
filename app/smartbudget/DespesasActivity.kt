package com.example.smartbudget

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DespesasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesas)

        val etDescricao = findViewById<EditText>(R.id.etDescricao)
        val etValor = findViewById<EditText>(R.id.etValor)
        val etData = findViewById<EditText>(R.id.etData)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val descricao = etDescricao.text.toString()
            val valor = etValor.text.toString().toDoubleOrNull()
            val data = etData.text.toString()

            if (descricao.isNotEmpty() && valor != null && data.isNotEmpty()) {
                val dbHelper = DatabaseHelper(this)
                val db = dbHelper.writableDatabase

                val values = ContentValues().apply {
                    put(DatabaseHelper.COLUMN_DESCRICAO, descricao)
                    put(DatabaseHelper.COLUMN_VALOR, valor)
                    put(DatabaseHelper.COLUMN_DATA, data)
                }

                val newRowId = db.insert(DatabaseHelper.TABLE_DESPESAS, null, values)

                if (newRowId != -1L) {
                    Toast.makeText(this, "Despesa salva com sucesso!", Toast.LENGTH_SHORT).show()
                    etDescricao.text.clear()
                    etValor.text.clear()
                    etData.text.clear()
                } else {
                    Toast.makeText(this, "Erro ao salvar despesa.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

