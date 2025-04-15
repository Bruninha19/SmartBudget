package com.example.smartbudget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "smartbudget.db";
    public static final int DATABASE_VERSION = 1;

    // Tabela de despesas
    public static final String TABLE_DESPESAS = "despesas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_VALOR = "valor";
    public static final String COLUMN_DATA = "data";

    // Tabela de receitas
    public static final String TABLE_RECEITAS = "receitas";
    public static final String COLUMN_RECEITA_ID = "id";
    public static final String COLUMN_RECEITA_DESCRICAO = "descricao";
    public static final String COLUMN_RECEITA_VALOR = "valor";
    public static final String COLUMN_RECEITA_DATA = "data";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDespesasTable = "CREATE TABLE " + TABLE_DESPESAS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRICAO + " TEXT, " +
                COLUMN_VALOR + " REAL, " +
                COLUMN_DATA + " TEXT);";

        String createReceitasTable = "CREATE TABLE " + TABLE_RECEITAS + " (" +
                COLUMN_RECEITA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_RECEITA_DESCRICAO + " TEXT, " +
                COLUMN_RECEITA_VALOR + " REAL, " +
                COLUMN_RECEITA_DATA + " TEXT);";

        db.execSQL(createDespesasTable);
        db.execSQL(createReceitasTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DESPESAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECEITAS);
        onCreate(db);
    }
}
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
