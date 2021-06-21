package com.example.bancodedadossqllite

//Programa de desmontra o uso de banco de dados SQlLite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            //Criar o banco de dados
            val bancoDeDados: SQLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null)

            //Criar a tabela
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) )")

            //Comando para apagar a tabela
            //bancoDeDados.execSQL("DROP TABLE pessoas")

            //Atualizando registro
            //bancoDeDados.execSQL("UPDATE pessoas SET nome = 'Diego' WHERE id = 6")

            //Deletando todos os registros da tabela
            //bancoDeDados.execSQL("DELETE FROM pessoas")

            //Deletando um usuário na tabela
            //bancoDeDados.execSQL("DELETE FROM pessoas WHERE id = 7")


            //Inserir dados
            // bancoDeDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Mario',33) ")
            // bancoDeDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Pedro',25) ")

            //Consulta Pessoas por nome e idade
//            val consultaPorNomeIdade: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome = 'Joao' AND idade=35"

            //Consulta Pessoas por idade
//            val consultaPoIdade: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade IN (33,35)"

//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade BETWEEN 30 AND 35"

//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade BETWEEN 30 AND 35"

//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome LIKE 'Ma%'"

//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome LIKE '%Ma%'"

            //Consulta por idade ascendente
//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE 1=1 ORDER BY idade ASC"

//            val consulta: String =
//                "SELECT nome, idade FROM pessoas " +
//                    "WHERE 1=1 ORDER BY nome ASC"

            val consulta: String =
                "SELECT id,nome, idade FROM pessoas " +
                    "WHERE 1=1"

            //Recuperar os dados
            val cursor: Cursor
            cursor = bancoDeDados.rawQuery(consulta, null)
//            cursor = bancoDeDados.rawQuery("SELECT nome,idade FROM pessoas", null)

            //Indices da tabela
            val indiceId: Int = cursor.getColumnIndex("id")
            val indiceNome: Int = cursor.getColumnIndex("nome")
            val indiceIdade: Int = cursor.getColumnIndex("idade")

            //Voltando o cursor no primeiro item da lista
            cursor.moveToFirst()
            while (cursor != null) {

                val nome: String = cursor.getString(indiceNome)
                val idade: String = cursor.getString(indiceIdade)
                val id: String = cursor.getString(indiceId)

                Log.i(
                    "Resultado - Id ", "$id Nome: $nome Idade: $idade"
                )
                cursor.moveToNext()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}