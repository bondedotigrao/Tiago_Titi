package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="frentista")
public class Frentista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_frentista;
    @Column(nullable = false,length=35)
    private String nomeFren;
    @Column(nullable = false)
    private double avaliacaoFrent;
    @ManyToOne
    @JoinColumn(name="cod_posto")
    private Posto posto;
    
    public Frentista(){
    }

    public Frentista(String nomeFren, double avaliacaoFrent, Posto posto) {
        this.nomeFren = nomeFren;
        this.avaliacaoFrent = avaliacaoFrent;
        this.posto = posto;
    }

    public int getId_frentista() {
        return id_frentista;
    }

    public void setId_frentista(int id_frentista) {
        this.id_frentista = id_frentista;
    }

    public String getNomeFren() {
        return nomeFren;
    }

    public void setNomeFren(String nomeFren) {
        this.nomeFren = nomeFren;
    }

    public double getAvaliacaoFrent() {
        return avaliacaoFrent;
    }

    public void setAvaliacaoFrent(double avaliacaoFrent) {
        this.avaliacaoFrent = avaliacaoFrent;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    @Override
    public String toString() {
        return "Frentista{" + "id_frentista=" + id_frentista + ", nomeFren=" + nomeFren + ", avaliacaoFrent=" + avaliacaoFrent + ", posto=" + posto + '}';
    }

    
    
    
    
    
}