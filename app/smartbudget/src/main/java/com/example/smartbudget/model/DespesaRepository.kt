
import android.content.Context
import android.database.Cursor
import com.example.smartbudget.database.DatabaseHelper

class DespesaRepository(context: Context?) {
    private val dbHelper: DatabaseHelper

    init {
        dbHelper = DatabaseHelper(context)
    }

    fun inserir(descricao: String?, valor: Double, data: String?) {
        dbHelper.inserirDespesa(descricao, valor, data)
    }

//    fun listar(): Cursor {
//        return dbHelper.listarDespesas()
//    }
//
//    fun deletar(id: Int) {
//        dbHelper.deletarDespesa(id)
//    }
}