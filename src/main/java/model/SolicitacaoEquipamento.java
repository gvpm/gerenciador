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
@Table(name = "solicitacao_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitacaoEquipamento.findAll", query = "SELECT s FROM SolicitacaoEquipamento s")
    , @NamedQuery(name = "SolicitacaoEquipamento.findByIdSolicitacaoEquipamento", query = "SELECT s FROM SolicitacaoEquipamento s WHERE s.idSolicitacaoEquipamento = :idSolicitacaoEquipamento")
    , @NamedQuery(name = "SolicitacaoEquipamento.findByDiaSemana", query = "SELECT s FROM SolicitacaoEquipamento s WHERE s.diaSemana = :diaSemana")
    , @NamedQuery(name = "SolicitacaoEquipamento.findByEstado", query = "SELECT s FROM SolicitacaoEquipamento s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitacaoEquipamento.findByHoraFim", query = "SELECT s FROM SolicitacaoEquipamento s WHERE s.horaFim = :horaFim")
    , @NamedQuery(name = "SolicitacaoEquipamento.findByHoraInicio", query = "SELECT s FROM SolicitacaoEquipamento s WHERE s.horaInicio = :horaInicio")})
public class SolicitacaoEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitacao_equipamento")
    private Integer idSolicitacaoEquipamento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitacaoEquipamento")
    private Collection<ReservaEquipamento> reservaEquipamentoCollection;
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id_equipamento")
    @ManyToOne(optional = false)
    private Equipamento idEquipamento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public SolicitacaoEquipamento() {
    }

    public SolicitacaoEquipamento(Integer idSolicitacaoEquipamento) {
        this.idSolicitacaoEquipamento = idSolicitacaoEquipamento;
    }

    public SolicitacaoEquipamento(Integer idSolicitacaoEquipamento, String diaSemana, String estado, Date horaFim, Date horaInicio) {
        this.idSolicitacaoEquipamento = idSolicitacaoEquipamento;
        this.diaSemana = diaSemana;
        this.estado = estado;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
    }

    public Integer getIdSolicitacaoEquipamento() {
        return idSolicitacaoEquipamento;
    }

    public void setIdSolicitacaoEquipamento(Integer idSolicitacaoEquipamento) {
        this.idSolicitacaoEquipamento = idSolicitacaoEquipamento;
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

    @XmlTransient
    public Collection<ReservaEquipamento> getReservaEquipamentoCollection() {
        return reservaEquipamentoCollection;
    }

    public void setReservaEquipamentoCollection(Collection<ReservaEquipamento> reservaEquipamentoCollection) {
        this.reservaEquipamentoCollection = reservaEquipamentoCollection;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacaoEquipamento != null ? idSolicitacaoEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitacaoEquipamento)) {
            return false;
        }
        SolicitacaoEquipamento other = (SolicitacaoEquipamento) object;
        if ((this.idSolicitacaoEquipamento == null && other.idSolicitacaoEquipamento != null) || (this.idSolicitacaoEquipamento != null && !this.idSolicitacaoEquipamento.equals(other.idSolicitacaoEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolicitacaoEquipamento[ idSolicitacaoEquipamento=" + idSolicitacaoEquipamento + " ]";
    }
    
}
