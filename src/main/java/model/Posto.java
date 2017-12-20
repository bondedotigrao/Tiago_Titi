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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="posto")
public class Posto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_posto;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false,length = 25)
    private String nome;
    @Column(nullable = false, length =25)
    private String distribuidora;
    @Column(nullable = false)
    private double precoGasolina;
    @Column(nullable = false)
    private double precoAlcool;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posto", fetch = FetchType.EAGER)
    private List<Frentista> frentistas;
    @ManyToOne
    @JoinColumn(name = "id_proprietario")
    private Cliente cliente;
    
    public Posto(){
        
    }

    public Posto(String endereco, String nome, String distribuidora, double precoGasolina, double precoAlcool, List<Frentista> frentistas, Cliente cliente) {
        this.endereco = endereco;
        this.nome = nome;
        this.distribuidora = distribuidora;
        this.precoGasolina = precoGasolina;
        this.precoAlcool = precoAlcool;
        this.frentistas = frentistas;
        this.cliente = cliente;
    }

    public int getId_posto() {
        return id_posto;
    }

    public void setId_posto(int id_posto) {
        this.id_posto = id_posto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getPrecoAlcool() {
        return precoAlcool;
    }

    public void setPrecoAlcool(double precoAlcool) {
        this.precoAlcool = precoAlcool;
    }

    public List<Frentista> getFrentistas() {
        return frentistas;
    }

    public void setFrentistas(List<Frentista> frentistas) {
        this.frentistas = frentistas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Posto{" + "id_posto=" + id_posto + ", endereco=" + endereco + ", nome=" + nome + ", distribuidora=" + distribuidora + ", precoGasolina=" + precoGasolina + ", precoAlcool=" + precoAlcool + ", frentistas=" + frentistas + ", cliente=" + cliente + '}';
    }
    
    

    

   
}
