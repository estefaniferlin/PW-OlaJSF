/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Calendar;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author 20202PF.CC0011
 */

@Named(value = "controleIndex") // esse value é o nome que vamos chamar la na tela   // quando nao aparecer o @Named, adicionar a biblioteca Java EE Web 8 API Library
@RequestScoped  // so dura enquanto estiver respondendo a requisição -> ciclo de vida mais curto, os dados sao trocados toda vez que recarrega a agina (exemplo a hora)
//@SessionScoped // ele cria uma instancia enquanto durar a seção do navegador, os dados nao ficam trocando a toda vez que voce recarrega a pagina (por exemplo a hora) (ciclo de vida de sessao)
//@ApplicationScoped // ciclo de vida um pouco mais longo -> quando eu executar pella primeira vez, ele vai mandar a instancia no mesmo lugar executado. Usar num exemplo quando tenho taxas fisicas, uma lista de produtos, que todos os usuarios vao usae mesmo (ciclo de vida de aplicação), so deixaa de existir qunado eu encerar a execução da aplicação do servidor 
public class ControleIndex implements Serializable{
    
    // par exibir uma msg na tela do index
    // por enquanto é so uma classse java
    // para se tornar controlador jsf, temos que colocar a anotação @named - se nao aparecer é pq naoi pegou algumas biblios - entao botao direito, library e add library chamada java ee web api library (algo assim)
    
    private String ola;
    private Calendar dataSO; 
    
    public ControleIndex(){
        ola = "Seja bem vindo ao JSF!";
        dataSO = Calendar.getInstance();
        System.out.println("Criou o controle index");
        mensagem("Criei uma mensagem no construtor");
    }
    
    public void mensagem(String texto){
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().getFlash().setKeepMessages(true); // manter mensagem mesmo com o contexto, assim conseguimos manter o ?faces-redirect=true e tambem mostrar as mensagens nos metodos index e sobre
        FacesMessage mensagem = new  FacesMessage(FacesMessage.SEVERITY_INFO, texto, "");
        contexto.addMessage(null, mensagem);
    }
    
// para fazer navegadcao de paginas temos que ter metodos
    // agora no index vou chamar eles
    public String sobre(){
        mensagem("Executei o método sobre...");
        return "sobre?faces-redirect=true"; // faz o redirecionamento completo, ou seja, atualiza o header
    }
    
    public String index(){
        mensagem("Executei o método index...");
        return "index?faces-redirect=true";
    }
    
    
    public String getOla() {
        return ola;
    }

    public void setOla(String ola) {
        this.ola = ola;
    }

    public Calendar getDataSO() {
        return dataSO;
    }

    public void setDataSO(Calendar dataSO) {
        this.dataSO = dataSO;
    }
    
    
}
