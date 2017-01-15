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
@Table(name = "reserva_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaEquipamento.findAll", query = "SELECT r FROM ReservaEquipamento r")
    , @NamedQuery(name = "ReservaEquipamento.findByIdReservaEquipamento", query = "SELECT r FROM ReservaEquipamento r WHERE r.idReservaEquipamento = :idReservaEquipamento")
    , @NamedQuery(name = "ReservaEquipamento.findByAtivo", query = "SELECT r FROM ReservaEquipamento r WHERE r.ativo = :ativo")
    , @NamedQuery(name = "ReservaEquipamento.findByEmMaos", query = "SELECT r FROM ReservaEquipamento r WHERE r.emMaos = :emMaos")
    , @NamedQuery(name = "ReservaEquipamento.findByProblema", query = "SELECT r FROM ReservaEquipamento r WHERE r.problema = :problema")})
public class ReservaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva_equipamento")
    private Integer idReservaEquipamento;
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
    @JoinColumn(name = "id_solicitacao_equipamento", referencedColumnName = "id_solicitacao_equipamento")
    @ManyToOne(optional = false)
    private SolicitacaoEquipamento idSolicitacaoEquipamento;

    public ReservaEquipamento() {
    }

    public ReservaEquipamento(Integer idReservaEquipamento) {
        this.idReservaEquipamento = idReservaEquipamento;
    }

    public ReservaEquipamento(Integer idReservaEquipamento, short ativo, short emMaos) {
        this.idReservaEquipamento = idReservaEquipamento;
        this.ativo = ativo;
        this.emMaos = emMaos;
    }

    public Integer getIdReservaEquipamento() {
        return idReservaEquipamento;
    }

    public void setIdReservaEquipamento(Integer idReservaEquipamento) {
        this.idReservaEquipamento = idReservaEquipamento;
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

    public SolicitacaoEquipamento getIdSolicitacaoEquipamento() {
        return idSolicitacaoEquipamento;
    }

    public void setIdSolicitacaoEquipamento(SolicitacaoEquipamento idSolicitacaoEquipamento) {
        this.idSolicitacaoEquipamento = idSolicitacaoEquipamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaEquipamento != null ? idReservaEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaEquipamento)) {
            return false;
        }
        ReservaEquipamento other = (ReservaEquipamento) object;
        if ((this.idReservaEquipamento == null && other.idReservaEquipamento != null) || (this.idReservaEquipamento != null && !this.idReservaEquipamento.equals(other.idReservaEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReservaEquipamento[ idReservaEquipamento=" + idReservaEquipamento + " ]";
    }
    
}
