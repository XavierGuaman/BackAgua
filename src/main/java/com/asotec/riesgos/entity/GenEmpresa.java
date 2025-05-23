/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * GenUsuarioModulo generated by hbm2java
 */
@Entity
@Table(name = "gen_empresa",
        schema = "public" //postgres
//schema = "dbo", catalog = "coop" //sqlserver
)
public class GenEmpresa implements java.io.Serializable{
    private long codEmpresa;
    private String nomEmpresa;
    private String nomAbreviado;
    private Long numRuc;
    private Character stsEmpresa;
    //private String txtEmail;
    //private String codeAppTerceros;

    
    
    
//    private String dirEmpresa;
//    private Long numTelefono1;
//    private Long numTelefono2;
//    private char stsFinDia;
//    private Long numFax;
//    private Date fecMov;
//    private String txtEmail;
//    private Character codTipoIdRepresentante;
//    private String numIdRepresentante;
//    private Long numRucContador;
//    private Character stsEmpresa;
//    private String nomGerente;
//    private String dir2Empresa;
//    private Long codMoneda;
    private String codFormatoImpLibreta;
//    private Long codInstUaf;
//    private String txtUbicacionServidorImagenes;
//    private Character stsServidorImagenes;
//    private Character stsEnvioEmail;
    
//    private Character sts_transferencia_virtual;
//    private Character sts_banca_virtual;
//    private Long val_max_transf_diario;
//    private Long val_max_transf_mensual;

    public GenEmpresa() {
    }

    public GenEmpresa(long codEmpresa, String nomEmpresa, String nomAbreviado, Long numRuc, Character stsEmpresa) {
        this.codEmpresa = codEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.nomAbreviado = nomAbreviado;
        this.numRuc = numRuc;
        this.stsEmpresa = stsEmpresa;
    }
    
    
    

//    public GenEmpresa(long codEmpresa, String nomAbreviado, char stsFinDia) {
//        this.codEmpresa = codEmpresa;
//        this.nomAbreviado = nomAbreviado;
//        this.stsFinDia = stsFinDia;
//    }
//
//    public GenEmpresa(long codEmpresa, String nomEmpresa, String nomAbreviado, Long numRuc, String dirEmpresa, Long numTelefono1, Long numTelefono2, char stsFinDia, Long numFax, Date fecMov, String txtEmail, Character codTipoIdRepresentante, String numIdRepresentante, Long numRucContador, Character stsEmpresa, String nomGerente, String dir2Empresa, Long codMoneda, String codFormatoImpLibreta, Long codInstUaf, String txtUbicacionServidorImagenes, Character stsServidorImagenes) {
//        this.codEmpresa = codEmpresa;
//        this.nomEmpresa = nomEmpresa;
//        this.nomAbreviado = nomAbreviado;
//        this.numRuc = numRuc;
//        this.dirEmpresa = dirEmpresa;
//        this.numTelefono1 = numTelefono1;
//        this.numTelefono2 = numTelefono2;
//        this.stsFinDia = stsFinDia;
//        this.numFax = numFax;
//        this.fecMov = fecMov;
//        this.txtEmail = txtEmail;
//        this.codTipoIdRepresentante = codTipoIdRepresentante;
//        this.numIdRepresentante = numIdRepresentante;
//        this.numRucContador = numRucContador;
//        this.stsEmpresa = stsEmpresa;
//        this.nomGerente = nomGerente;
//        this.dir2Empresa = dir2Empresa;
//        this.codMoneda = codMoneda;
//        this.codFormatoImpLibreta = codFormatoImpLibreta;
//        this.codInstUaf = codInstUaf;
//        this.txtUbicacionServidorImagenes = txtUbicacionServidorImagenes;
//        this.stsServidorImagenes = stsServidorImagenes;
//    }

    @Id
    @Column(name = "cod_empresa", unique = true, nullable = false, precision = 3, scale = 0)
    public long getCodEmpresa() {
        return this.codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "nom_empresa", length = 100)
    public String getNomEmpresa() {
        return this.nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    @Column(name = "nom_abreviado", nullable = false, length = 20)
    public String getNomAbreviado() {
        return this.nomAbreviado;
    }

    public void setNomAbreviado(String nomAbreviado) {
        this.nomAbreviado = nomAbreviado;
    }

    @Column(name = "num_ruc", precision = 13, scale = 0)
    public Long getNumRuc() {
        return this.numRuc;
    }

    public void setNumRuc(Long numRuc) {
        this.numRuc = numRuc;
    }
    
//   @Column(name = "txt_email")
//    public String getTxtEmail() {
//        return txtEmail;
//    }
//
//    public void setTxtEmail(String txtEmail) {
//        this.txtEmail = txtEmail;
//    }
//
//    @Column(name = "cod_app_terceros")
//    public String getCodeAppTerceros() {
//        return codeAppTerceros;
//    }
//
//    public void setCodeAppTerceros(String codeAppTerceros) {
//        this.codeAppTerceros = codeAppTerceros;
//    }

//    @Column(name = "dir_empresa", length = 100)
//    public String getDirEmpresa() {
//        return this.dirEmpresa;
//    }
//
//    public void setDirEmpresa(String dirEmpresa) {
//        this.dirEmpresa = dirEmpresa;
//    }
//
//    @Column(name = "num_telefono1", precision = 10, scale = 0)
//    public Long getNumTelefono1() {
//        return this.numTelefono1;
//    }
//
//    public void setNumTelefono1(Long numTelefono1) {
//        this.numTelefono1 = numTelefono1;
//    }
//
//    @Column(name = "num_telefono2", precision = 10, scale = 0)
//    public Long getNumTelefono2() {
//        return this.numTelefono2;
//    }
//
//    public void setNumTelefono2(Long numTelefono2) {
//        this.numTelefono2 = numTelefono2;
//    }
//
//    @Column(name = "sts_fin_dia", nullable = false, length = 1)
//    public char getStsFinDia() {
//        return this.stsFinDia;
//    }
//
//    public void setStsFinDia(char stsFinDia) {
//        this.stsFinDia = stsFinDia;
//    }
//
//    @Column(name = "num_fax", precision = 10, scale = 0)
//    public Long getNumFax() {
//        return this.numFax;
//    }
//
//    public void setNumFax(Long numFax) {
//        this.numFax = numFax;
//    }
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "fec_mov", length = 13)
//    public Date getFecMov() {
//        return this.fecMov;
//    }
//
//    public void setFecMov(Date fecMov) {
//        this.fecMov = fecMov;
//    }
//
//    @Column(name = "txt_email", length = 100)
//    public String getTxtEmail() {
//        return this.txtEmail;
//    }
//
//    public void setTxtEmail(String txtEmail) {
//        this.txtEmail = txtEmail;
//    }
//
//    @Column(name = "cod_tipo_id_representante", length = 1)
//    public Character getCodTipoIdRepresentante() {
//        return this.codTipoIdRepresentante;
//    }
//
//    public void setCodTipoIdRepresentante(Character codTipoIdRepresentante) {
//        this.codTipoIdRepresentante = codTipoIdRepresentante;
//    }
//
//    @Column(name = "num_id_representante", length = 20)
//    public String getNumIdRepresentante() {
//        return this.numIdRepresentante;
//    }
//
//    public void setNumIdRepresentante(String numIdRepresentante) {
//        this.numIdRepresentante = numIdRepresentante;
//    }
//
//    @Column(name = "num_ruc_contador", precision = 13, scale = 0)
//    public Long getNumRucContador() {
//        return this.numRucContador;
//    }
//
//    public void setNumRucContador(Long numRucContador) {
//        this.numRucContador = numRucContador;
//    }
//
    @Column(name = "sts_empresa", length = 1)
    public Character getStsEmpresa() {
        return this.stsEmpresa;
    }

    public void setStsEmpresa(Character stsEmpresa) {
        this.stsEmpresa = stsEmpresa;
    }
//
//    @Column(name = "nom_gerente", length = 100)
//    public String getNomGerente() {
//        return this.nomGerente;
//    }
//
//    public void setNomGerente(String nomGerente) {
//        this.nomGerente = nomGerente;
//    }
//
//    @Column(name = "dir2_empresa", length = 100)
//    public String getDir2Empresa() {
//        return this.dir2Empresa;
//    }
//
//    public void setDir2Empresa(String dir2Empresa) {
//        this.dir2Empresa = dir2Empresa;
//    }
//
//    @Column(name = "cod_moneda", precision = 2, scale = 0)
//    public Long getCodMoneda() {
//        return this.codMoneda;
//    }
//
//    public void setCodMoneda(Long codMoneda) {
//        this.codMoneda = codMoneda;
//    }
//
    @Column(name = "cod_formato_imp_libreta", length = 100)
    public String getCodFormatoImpLibreta() {
        return this.codFormatoImpLibreta;
    }

    public void setCodFormatoImpLibreta(String codFormatoImpLibreta) {
        this.codFormatoImpLibreta = codFormatoImpLibreta;
    }

//    @Column(name = "cod_inst_uaf", precision = 10, scale = 0)
//    public Long getCodInstUaf() {
//        return this.codInstUaf;
//    }
//
//    public void setCodInstUaf(Long codInstUaf) {
//        this.codInstUaf = codInstUaf;
//    }
//
//    @Column(name = "txt_ubicacion_servidor_imagenes", length = 500)
//    public String getTxtUbicacionServidorImagenes() {
//        return this.txtUbicacionServidorImagenes;
//    }
//
//    public void setTxtUbicacionServidorImagenes(String txtUbicacionServidorImagenes) {
//        this.txtUbicacionServidorImagenes = txtUbicacionServidorImagenes;
//    }
//
//    @Column(name = "sts_servidor_imagenes", length = 1)
//    public Character getStsServidorImagenes() {
//        return this.stsServidorImagenes;
//    }
//
//    public void setStsServidorImagenes(Character stsServidorImagenes) {
//        this.stsServidorImagenes = stsServidorImagenes;
//    }

//    @Column(name = "sts_transferencia_virtual", length = 1)
//    public Character getSts_transferencia_virtual() {
//        return sts_transferencia_virtual;
//    }
//
//    public void setSts_transferencia_virtual(Character sts_transferencia_virtual) {
//        this.sts_transferencia_virtual = sts_transferencia_virtual;
//    }
//
//    @Column(name = "sts_banca_virtual", length = 1)
//    public Character getSts_banca_virtual() {
//        return sts_banca_virtual;
//    }
//
//    public void setSts_banca_virtual(Character sts_banca_virtual) {
//        this.sts_banca_virtual = sts_banca_virtual;
//    }
//
//    @Column(name = "val_max_transf_diario", precision = 2, scale = 0)
//    public Long getVal_max_transf_diario() {
//        return val_max_transf_diario;
//    }
//
//    public void setVal_max_transf_diario(Long val_max_transf_diario) {
//        this.val_max_transf_diario = val_max_transf_diario;
//    }
//
//    @Column(name = "val_max_transf_mensual", precision = 2, scale = 0)
//    public Long getVal_max_transf_mensual() {
//        return val_max_transf_mensual;
//    }
//
//    public void setVal_max_transf_mensual(Long val_max_transf_mensual) {
//        this.val_max_transf_mensual = val_max_transf_mensual;
//    }
//
//    @Column(name = "sts_envio_email", length = 1)
//    public Character getStsEnvioEmail() {
//        return stsEnvioEmail;
//    }
//
//    public void setStsEnvioEmail(Character stsEnvioEmail) {
//        this.stsEnvioEmail = stsEnvioEmail;
//    }

    
    
//    @Override
//    public String toString() {
//        return "GenEmpresa{" + "codEmpresa=" + codEmpresa + ", nomEmpresa=" + nomEmpresa + ", nomAbreviado=" + nomAbreviado + ", numRuc=" + numRuc + ", dirEmpresa=" + dirEmpresa + ", numTelefono1=" + numTelefono1 + ", numTelefono2=" + numTelefono2 + ", stsFinDia=" + stsFinDia + ", numFax=" + numFax + ", fecMov=" + fecMov + ", txtEmail=" + txtEmail + ", codTipoIdRepresentante=" + codTipoIdRepresentante + ", numIdRepresentante=" + numIdRepresentante + ", numRucContador=" + numRucContador + ", stsEmpresa=" + stsEmpresa + ", nomGerente=" + nomGerente + ", dir2Empresa=" + dir2Empresa + ", codMoneda=" + codMoneda + ", codFormatoImpLibreta=" + codFormatoImpLibreta + ", codInstUaf=" + codInstUaf + ", txtUbicacionServidorImagenes=" + txtUbicacionServidorImagenes + ", stsServidorImagenes=" + stsServidorImagenes + '}';
//    }

}
