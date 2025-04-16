package com.example.smartbudget.repository

import com.example.smartbudget.model.Despesa
import com.example.smartbudget.model.Receita

object FinancasRepository {

    // Listas para armazenar as despesas e as receitas
    private val despesas = mutableListOf<Despesa>()
    private val receitas = mutableListOf<Receita>()

    // Variável para controlar os IDs das despesas e receitas
    private var proximoId = 1

    // Função para adicionar uma nova despesa
    fun adicionarDespesa(descricao: String, valor: Double, data: String) {
        // Cria uma nova despesa e adiciona à lista de despesas
        val despesa = Despesa(proximoId++, descricao, valor, data)
        despesas.add(despesa)
    }

    // Função para adicionar uma nova receita
    fun adicionarReceita(descricao: String, valor: Double, data: String) {
        // Cria uma nova receita e adiciona à lista de receitas
        val receita = Receita(proximoId++, descricao, valor, data)
        receitas.add(receita)
    }

    // Função para listar todas as despesas
    fun listarDespesas(): List<Despesa> = despesas

    // Função para listar todas as receitas
    fun listarReceitas(): List<Receita> = receitas

    // Função para excluir uma despesa pelo ID
    fun excluirDespesa(id: Int) {
        // Remove a despesa com o ID fornecido
        despesas.removeIf { it.id == id }
    }

    // Função para excluir uma receita pelo ID
    fun excluirReceita(id: Int) {
        // Remove a receita com o ID fornecido
        receitas.removeIf { it.id == id }
    }

    // Função para calcular o total das despesas
    fun calcularTotalDespesas(): Double = despesas.sumOf { it.valor }

    // Função para calcular o total das receitas
    fun calcularTotalReceitas(): Double = receitas.sumOf { it.valor }

    // Função para calcular o saldo, que é a diferença entre receitas e despesas
    fun calcularSaldo(): Double = calcularTotalReceitas() - calcularTotalDespesas()
}
