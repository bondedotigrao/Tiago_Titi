package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cupom")
public class Cupom implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cupom;
    @Column
    private double valorDesconto;
    @Column
    private double litragem;
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name="id_posto")
    private Posto posto;
    
    public Cupom(){
        
    }

    public Cupom(double valorDesconto, double litragem, Usuario usuario, Posto posto) {
        this.valorDesconto = valorDesconto;
        this.litragem = litragem;
        this.usuario = usuario;
        this.posto = posto;
    }

    public int getId_cupom() {
        return id_cupom;
    }

    public void setId_cupom(int id_cupom) {
        this.id_cupom = id_cupom;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getLitragem() {
        return litragem;
    }

    public void setLitragem(double litragem) {
        this.litragem = litragem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    

    
}
