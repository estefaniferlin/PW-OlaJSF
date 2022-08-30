/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 20202PF.CC0011
 */
@Named(value = "controleAjax")
@ViewScoped
public class ControleAjax implements Serializable{
    
    private String entrada;
    private String saida;
    private Boolean exibir;
    
    public ControleAjax(){
        exibir = false;
    }
    
    public void mudarExibir(){
        exibir = !exibir; 
    }
    
    //metodo de processar com ajax serao void para nao ir para outra tela
    public void processar(){
        saida = "Você digitou " + entrada;
        entrada = "";
    }
    
    public String irAjax(){
        return "ajax?faces-redirect=true";  // esse nome ajax temos que criar um arquivo em web pages com esse nome
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }
    
    
}
