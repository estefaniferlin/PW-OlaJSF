/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 20202PF.CC0011
 */
@Named(value = "controleFormulario")
//@RequestScoped
@SessionScoped
public class ControleFormulario implements Serializable{
    
    private String nome;
    private String funcao;
    private Boolean ativo;
    
    public ControleFormulario(){
        
    }
    
    // metodo para ir ao formulario, ele acessa o formulario e retorna na tela, mas por usarmos requestScoped ele como ja tinha passado a requisicao, ele nao mostra mais nada, ai usamos a de sessao
    public String irFormulario(){
        return "formulario?faces-redirect=true";
    }
    
    // para exibir os dados
    public String exibirDados(){
        return "dados?faces-redirect=true";
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
