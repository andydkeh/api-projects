package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Projeto {

  private @Id @GeneratedValue Long id;
  private String nome_projeto;
  private String nome_cliente;
  private String nome_gestor;
  private Integer qtd_funcionarios;
  

  Projeto() {}

  Projeto(String nome_projeto, String nome_cliente, String nome_gestor, Integer qtd_funcionarios) {

    this.nome_projeto = nome_projeto;
    this.nome_cliente = nome_cliente;
    this.nome_gestor = nome_gestor;
    this.qtd_funcionarios = qtd_funcionarios;
  }

  public Long getId() {
    return this.id;
  }

  public String getProjeto() {
    return this.nome_projeto;
  }

  public String getCliente() {
    return this.nome_cliente;
  }

  public String getGestor() {
	    return this.nome_gestor;
  }
  
  public Integer getFuncionarios() {
	    return this.qtd_funcionarios;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public void setProjeto(String nome_projeto) {
    this.nome_projeto = nome_projeto;
  }

  public void setCliente(String nome_cliente) {
	  this.nome_cliente = nome_cliente;
  }

  public void setGestor(String nome_gestor) {
	  this.nome_gestor = nome_gestor;
  }
	  
  public void setFuncionarios(Integer qtd_funcionarios) {
	  this.qtd_funcionarios = qtd_funcionarios;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Projeto))
      return false;
    Projeto employee = (Projeto) o;
    return Objects.equals(this.id, employee.id) 
    	&& Objects.equals(this.nome_projeto, employee.nome_projeto)
        && Objects.equals(this.nome_cliente, employee.nome_cliente)
        && Objects.equals(this.nome_gestor, employee.nome_gestor)
        && Objects.equals(this.qtd_funcionarios, employee.qtd_funcionarios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nome_projeto, this.nome_cliente, this.nome_gestor, this.qtd_funcionarios);
  }

  @Override
  public String toString() {
    return "PROJETOS{" + "id=" + this.id + ", nome_projeto='" + this.nome_cliente + '\'' + ", nome_gestor='" + this.nome_gestor + '\'' + ", nome_projeto='" + this.nome_gestor + '\'' + ", qtd_funcionarios='" + this.qtd_funcionarios + '\'' + '}';
  }
}
