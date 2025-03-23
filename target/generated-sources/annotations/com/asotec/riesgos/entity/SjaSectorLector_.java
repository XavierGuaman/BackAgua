package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.SjaSectorLectorId;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-22T20:02:21")
@StaticMetamodel(SjaSectorLector.class)
public class SjaSectorLector_ { 

    public static volatile SingularAttribute<SjaSectorLector, Long> codProvincia;
    public static volatile SingularAttribute<SjaSectorLector, Long> codSector;
    public static volatile SingularAttribute<SjaSectorLector, Character> stsAsignacion;
    public static volatile SingularAttribute<SjaSectorLector, SjaSectorLectorId> id;
    public static volatile SingularAttribute<SjaSectorLector, Long> codCanton;
    public static volatile SingularAttribute<SjaSectorLector, Long> codEmpleado;

}