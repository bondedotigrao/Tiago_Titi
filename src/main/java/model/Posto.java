package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    @ManyToOne
    @JoinColumn(name = "id_proprietario")
    private Cliente cliente;
    
    @Deprecated
    public Posto(){
        
    }

    public Posto(String endereco, String nome, String distribuidora, double precoGasolina, double precoAlcool, Cliente cliente) {
        this.endereco = endereco;
        this.nome = nome;
        this.distribuidora = distribuidora;
        this.precoGasolina = precoGasolina;
        this.precoAlcool = precoAlcool;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_posto;
        hash = 37 * hash + Objects.hashCode(this.endereco);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.distribuidora);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.precoGasolina) ^ (Double.doubleToLongBits(this.precoGasolina) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.precoAlcool) ^ (Double.doubleToLongBits(this.precoAlcool) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posto other = (Posto) obj;
        if (this.id_posto != other.id_posto) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoGasolina) != Double.doubleToLongBits(other.precoGasolina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoAlcool) != Double.doubleToLongBits(other.precoAlcool)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.distribuidora, other.distribuidora)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Posto{" + "id_posto=" + id_posto + ", endereco=" + endereco + ", nome=" + nome + ", distribuidora=" + distribuidora + ", precoGasolina=" + precoGasolina + ", precoAlcool=" + precoAlcool + ", cliente=" + cliente + '}';
    }

   
}
