package com.gabrielestudo.gerenciador_de_tarefas.model;

public enum TaskStatus {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluído"),
    DESISTIU("Desistiu");

    private final String descricao;

    TaskStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}