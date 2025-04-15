// Dentro de DespesasActivity.kt
val dbHelper = DatabaseHelper(this)
val db = dbHelper.writableDatabase

val values = ContentValues().apply {
    put(DatabaseHelper.COLUMN_DESCRICAO, "SmartBudget)
    put(DatabaseHelper.COLUMN_VALOR, 120.50)
    put(DatabaseHelper.COLUMN_DATA, "2025-04-15")
}

val newRowId = db.insert(DatabaseHelper.TABLE_DESPESAS, null, values)

if (newRowId != -1L) {
    Toast.makeText(this, "Despesa salva com sucesso!", Toast.LENGTH_SHORT).show()
} else {
    Toast.makeText(this, "Erro ao salvar despesa", Toast.LENGTH_SHORT).show()
}
