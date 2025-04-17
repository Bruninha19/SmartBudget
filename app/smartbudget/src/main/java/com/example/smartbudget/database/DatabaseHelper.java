package com.example.smartbudget.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.smartbudget.model.Despesa;

import java.util.ArrayList;
import java.util.List;





import com.example.smartbudget.model.Despesa;

import java.util.List;

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

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context; // usamos para o Toast depois
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

    // Método para inserir uma despesa
    public void inserirDespesa(String descricao, double valor, String data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRICAO, descricao);
        values.put(COLUMN_VALOR, valor);
        values.put(COLUMN_DATA, data);

        long result = db.insert(TABLE_DESPESAS, null, values);

        if (result != -1) {
            Toast.makeText(context, "Despesa salva com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Erro ao salvar despesa", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

// Inserir receita
    public void inserirReceita(String descricao, double valor, String data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRICAO, descricao);
        values.put(COLUMN_VALOR, valor);
        values.put(COLUMN_DATA, data);

        long result = db.insert(TABLE_RECEITAS, null, values);

        if (result != -1) {
            Toast.makeText(context, "Receita salva com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Erro ao salvar receita", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

  /*  public List<Despesa> buscarDespesas(String textoBusca) {
        List<Despesa> listaDespesas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_DESPESAS + " WHERE " + COLUMN_DESCRICAO + " LIKE ?",
                new String[]{"%" + textoBusca + "%"}
        );

        if (cursor.moveToFirst()) {
            do {
                Despesa despesa = new Despesa();
                despesa.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                despesa.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRICAO)));
                despesa.setValor(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_VALOR)));
                despesa.setData(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATA)));

                listaDespesas.add(despesa);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listaDespesas;
    }

*/


}
