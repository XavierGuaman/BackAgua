package com.asotec.riesgos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-04T09:30:09")
@StaticMetamodel(NovedadesLecturas.class)
public class NovedadesLecturas_ { 

    public static volatile SingularAttribute<NovedadesLecturas, String> nomSector;
    public static volatile SingularAttribute<NovedadesLecturas, String> codUsuario;
    public static volatile SingularAttribute<NovedadesLecturas, Date> fecLectura;
    public static volatile SingularAttribute<NovedadesLecturas, String> codMedidor;
    public static volatile SingularAttribute<NovedadesLecturas, Long> codEmpresa;
    public static volatile SingularAttribute<NovedadesLecturas, Long> valLecturaFria;
    public static volatile SingularAttribute<NovedadesLecturas, String> tipoAnomalia;
    public static volatile SingularAttribute<NovedadesLecturas, String> nomAbonado;
    public static volatile SingularAttribute<NovedadesLecturas, String> codAbonado;
    public static volatile SingularAttribute<NovedadesLecturas, Long> valLecturaAnteriorFria;
    public static volatile SingularAttribute<NovedadesLecturas, Long> diferencia;

}