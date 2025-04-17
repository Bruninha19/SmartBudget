package com.example.smartbudget.model

class Despesa {
    var id: Int = 0
    var descricao: String = ""
    var valor: Double = 0.0
    var data: String = ""

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getDescricao(): String {
        return descricao
    }

    fun setDescricao(descricao: String) {
        this.descricao = descricao
    }

    fun getValor(): Double {
        return valor
    }

    fun setValor(valor: Double) {
        this.valor = valor
    }

    fun getData(): String {
        return data
    }

    fun setData(data: String) {
        this.data = data
    }
}
