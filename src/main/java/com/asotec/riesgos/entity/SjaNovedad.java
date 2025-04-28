/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author rolan
 */
@Entity
@Table(name = "sja_novedad", schema = "public")
public class SjaNovedad implements Serializable{
    private SjaNovedadId id;
    private Date fecUsrMod;
    private Long codUsrMod;
    private String txtNovedad;
    private String codUsuario;
    private Boolean stsNovedad;
    private Long idNovedad;

    
    

    @EmbeddedId
    public SjaNovedadId getId() {
        return id;
    }

    public void setId(SjaNovedadId id) {
        this.id = id;
    }

    @Column(name = "fec_usr_mod", columnDefinition = "timestamp without time zone")
    public Date getFecUsrMod() {
        return fecUsrMod;
    }

    public void setFecUsrMod(Date fecUsrMod) {
        this.fecUsrMod = fecUsrMod;
    }

    @Column(name = "cod_usr_mod")
    public Long getCodUsrMod() {
        return codUsrMod;
    }

    public void setCodUsrMod(Long codUsrMod) {
        this.codUsrMod = codUsrMod;
    }

    @Column(name = "txt_novedad", length = 200)
    public String getTxtNovedad() {
        return txtNovedad;
    }

    public void setTxtNovedad(String txtNovedad) {
        this.txtNovedad = txtNovedad;
    }

    @Column(name = "cod_usuario", length = 20)
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Column(name = "sts_novedad")
    public Boolean getStsNovedad() {
        return stsNovedad;
    }

    public void setStsNovedad(Boolean stsNovedad) {
        this.stsNovedad = stsNovedad;
    }
    
    @Column(name = "id_novedad", length = 3)
    public Long getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Long idNovedad) {
        this.idNovedad = idNovedad;
    }
    
}
