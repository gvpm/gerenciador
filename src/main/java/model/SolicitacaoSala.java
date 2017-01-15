/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gvpm
 */
@Entity
@Table(name = "solicitacao_sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitacaoSala.findAll", query = "SELECT s FROM SolicitacaoSala s")
    , @NamedQuery(name = "SolicitacaoSala.findByIdSolicitacaoSala", query = "SELECT s FROM SolicitacaoSala s WHERE s.idSolicitacaoSala = :idSolicitacaoSala")
    , @NamedQuery(name = "SolicitacaoSala.findByDiaSemana", query = "SELECT s FROM SolicitacaoSala s WHERE s.diaSemana = :diaSemana")
    , @NamedQuery(name = "SolicitacaoSala.findByEstado", query = "SELECT s FROM SolicitacaoSala s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitacaoSala.findByHoraFim", query = "SELECT s FROM SolicitacaoSala s WHERE s.horaFim = :horaFim")
    , @NamedQuery(name = "SolicitacaoSala.findByHoraInicio", query = "SELECT s FROM SolicitacaoSala s WHERE s.horaInicio = :horaInicio")})
public class SolicitacaoSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitacao_sala")
    private Integer idSolicitacaoSala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne(optional = false)
    private Sala idSala;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitacaoSala")
    private Collection<ReservaSala> reservaSalaCollection;

    public SolicitacaoSala() {
    }

    public SolicitacaoSala(Integer idSolicitacaoSala) {
        this.idSolicitacaoSala = idSolicitacaoSala;
    }

    public SolicitacaoSala(Integer idSolicitacaoSala, String diaSemana, String estado, Date horaFim, Date horaInicio) {
        this.idSolicitacaoSala = idSolicitacaoSala;
        this.diaSemana = diaSemana;
        this.estado = estado;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
    }

    public Integer getIdSolicitacaoSala() {
        return idSolicitacaoSala;
    }

    public void setIdSolicitacaoSala(Integer idSolicitacaoSala) {
        this.idSolicitacaoSala = idSolicitacaoSala;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<ReservaSala> getReservaSalaCollection() {
        return reservaSalaCollection;
    }

    public void setReservaSalaCollection(Collection<ReservaSala> reservaSalaCollection) {
        this.reservaSalaCollection = reservaSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacaoSala != null ? idSolicitacaoSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitacaoSala)) {
            return false;
        }
        SolicitacaoSala other = (SolicitacaoSala) object;
        if ((this.idSolicitacaoSala == null && other.idSolicitacaoSala != null) || (this.idSolicitacaoSala != null && !this.idSolicitacaoSala.equals(other.idSolicitacaoSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolicitacaoSala[ idSolicitacaoSala=" + idSolicitacaoSala + " ]";
    }
    
}
