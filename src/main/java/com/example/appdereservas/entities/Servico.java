package com.example.appdereservas.entities;

import javax.persistence.*;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String Categoria;
    private String Descricao;
    private Double Valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Servico() {
    }

    public Servico(Long id, String nome, String categoria, String descricao, Double valor, Cliente cliente) {
        this.id = id;
        this.Nome = nome;
        this.Categoria = categoria;
        this.Descricao = descricao;
        this.Valor = valor;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Serviço{" +
                "Nome='" + Nome + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", Valor=" + Valor +
                '}';
    }

   /* Recepionista = new ArrayList<>{

    }*/
}
