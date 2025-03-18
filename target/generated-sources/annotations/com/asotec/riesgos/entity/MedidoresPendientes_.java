package com.asotec.riesgos.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-17T20:29:30")
@StaticMetamodel(MedidoresPendientes.class)
public class MedidoresPendientes_ { 

    public static volatile SingularAttribute<MedidoresPendientes, String> nomSector;
    public static volatile SingularAttribute<MedidoresPendientes, String> codMedidor;
    public static volatile SingularAttribute<MedidoresPendientes, Long> codSector;
    public static volatile SingularAttribute<MedidoresPendientes, BigDecimal> valSaldo;
    public static volatile SingularAttribute<MedidoresPendientes, String> nomAbonado;
    public static volatile SingularAttribute<MedidoresPendientes, String> codAbonado;
    public static volatile SingularAttribute<MedidoresPendientes, Long> secuencial;

}