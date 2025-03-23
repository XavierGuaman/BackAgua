package com.asotec.riesgos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-22T20:02:21")
@StaticMetamodel(MedidoresConDeuda.class)
public class MedidoresConDeuda_ { 

    public static volatile SingularAttribute<MedidoresConDeuda, Long> numMesPendientes;
    public static volatile SingularAttribute<MedidoresConDeuda, String> nomSector;
    public static volatile SingularAttribute<MedidoresConDeuda, String> numId;
    public static volatile SingularAttribute<MedidoresConDeuda, String> codMedidor;
    public static volatile SingularAttribute<MedidoresConDeuda, Long> codEmpresa;
    public static volatile SingularAttribute<MedidoresConDeuda, Date> fecLecUltima;
    public static volatile SingularAttribute<MedidoresConDeuda, String> txtCorreo;
    public static volatile SingularAttribute<MedidoresConDeuda, String> txtTelefono;
    public static volatile SingularAttribute<MedidoresConDeuda, Double> valSaldo;
    public static volatile SingularAttribute<MedidoresConDeuda, String> nomAbonado;
    public static volatile SingularAttribute<MedidoresConDeuda, String> txtObservacion;
    public static volatile SingularAttribute<MedidoresConDeuda, String> codAbonado;
    public static volatile SingularAttribute<MedidoresConDeuda, String> codTipoId;

}