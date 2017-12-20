package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column (length = 40)
    private String nome;
    @Column (length = 40)
    private String cpf;
    @Column (length = 40)
    private String email;
    @Column (length = 40)
    private String numCelular;
    @Column (length = 20)
    private String login;
    @Column (length = 10)
    private String senha;
    
    public Usuario(){
        
    }
    
    public Usuario(String nome, String cpf, String email, String numCelular, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numCelular = numCelular;
        this.login = login;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", numCelular=" + numCelular + ", login=" + login + ", senha=" + senha + '}';
    }

    


   }
