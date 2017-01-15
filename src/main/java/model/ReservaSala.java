/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gvpm
 */
@Entity
@Table(name = "reserva_sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaSala.findAll", query = "SELECT r FROM ReservaSala r")
    , @NamedQuery(name = "ReservaSala.findByIdReservaSala", query = "SELECT r FROM ReservaSala r WHERE r.idReservaSala = :idReservaSala")
    , @NamedQuery(name = "ReservaSala.findByAtivo", query = "SELECT r FROM ReservaSala r WHERE r.ativo = :ativo")
    , @NamedQuery(name = "ReservaSala.findByEmMaos", query = "SELECT r FROM ReservaSala r WHERE r.emMaos = :emMaos")
    , @NamedQuery(name = "ReservaSala.findByProblema", query = "SELECT r FROM ReservaSala r WHERE r.problema = :problema")})
public class ReservaSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva_sala")
    private Integer idReservaSala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private short ativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "em_maos")
    private short emMaos;
    @Size(max = 45)
    @Column(name = "problema")
    private String problema;
    @JoinColumn(name = "id_solicitacao_sala", referencedColumnName = "id_solicitacao_sala")
    @ManyToOne(optional = false)
    private SolicitacaoSala idSolicitacaoSala;

    public ReservaSala() {
    }

    public ReservaSala(Integer idReservaSala) {
        this.idReservaSala = idReservaSala;
    }

    public ReservaSala(Integer idReservaSala, short ativo, short emMaos) {
        this.idReservaSala = idReservaSala;
        this.ativo = ativo;
        this.emMaos = emMaos;
    }

    public Integer getIdReservaSala() {
        return idReservaSala;
    }

    public void setIdReservaSala(Integer idReservaSala) {
        this.idReservaSala = idReservaSala;
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    public short getEmMaos() {
        return emMaos;
    }

    public void setEmMaos(short emMaos) {
        this.emMaos = emMaos;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public SolicitacaoSala getIdSolicitacaoSala() {
        return idSolicitacaoSala;
    }

    public void setIdSolicitacaoSala(SolicitacaoSala idSolicitacaoSala) {
        this.idSolicitacaoSala = idSolicitacaoSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaSala != null ? idReservaSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaSala)) {
            return false;
        }
        ReservaSala other = (ReservaSala) object;
        if ((this.idReservaSala == null && other.idReservaSala != null) || (this.idReservaSala != null && !this.idReservaSala.equals(other.idReservaSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReservaSala[ idReservaSala=" + idReservaSala + " ]";
    }
    
}
