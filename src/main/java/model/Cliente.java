package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    @Column(nullable = false,length = 40)
    private String nome;
    @Column(nullable = false,length = 30)
    private String cnpj;
    @Column(length = 40)
    private String email;
    @Column(length = 30)
    private String login;
    @Column(length = 30)
    private String senha;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Posto> postos;
    
    public Cliente(){
        
    }

    public Cliente(String nome, String cnpj, String email, String login, String senha, List<Posto> postos) {
        
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.postos = postos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Posto> getPostos() {
        return postos;
    }

    public void setPostos(List<Posto> postos) {
        this.postos = postos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nome=" + nome + ", cnpj=" + cnpj + ", email=" + email + ", login=" + login + ", senha=" + senha + ", postos=" + postos + '}';
    }
    
    
    
}