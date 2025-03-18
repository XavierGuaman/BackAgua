package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.SjaMedidorId;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-17T20:29:30")
@StaticMetamodel(SjaMedidor.class)
public class SjaMedidor_ { 

    public static volatile SingularAttribute<SjaMedidor, String> txtDireccion;
    public static volatile SingularAttribute<SjaMedidor, Long> periodo;
    public static volatile SingularAttribute<SjaMedidor, String> urlFoto;
    public static volatile SingularAttribute<SjaMedidor, String> stsMedidorActivo;
    public static volatile SingularAttribute<SjaMedidor, String> txtLongitud;
    public static volatile SingularAttribute<SjaMedidor, Long> valLectActualFria;
    public static volatile SingularAttribute<SjaMedidor, String> stsLectura;
    public static volatile SingularAttribute<SjaMedidor, Long> valLecAnteriorCaliente;
    public static volatile SingularAttribute<SjaMedidor, Long> valLectAnteriorFria;
    public static volatile SingularAttribute<SjaMedidor, String> codCatastro;
    public static volatile SingularAttribute<SjaMedidor, Long> valLectActualCaliente;
    public static volatile SingularAttribute<SjaMedidor, Long> codProvincia;
    public static volatile SingularAttribute<SjaMedidor, Long> codSector;
    public static volatile SingularAttribute<SjaMedidor, BigDecimal> valSaldo;
    public static volatile SingularAttribute<SjaMedidor, SjaMedidorId> id;
    public static volatile SingularAttribute<SjaMedidor, Long> numMesPendiente;
    public static volatile SingularAttribute<SjaMedidor, String> codAbonado;
    public static volatile SingularAttribute<SjaMedidor, String> codTarifa;
    public static volatile SingularAttribute<SjaMedidor, Long> codCanton;
    public static volatile SingularAttribute<SjaMedidor, String> txtLatitud;

}