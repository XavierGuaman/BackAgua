package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.SjaNovedadId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-24T21:32:58")
@StaticMetamodel(SjaNovedad.class)
public class SjaNovedad_ { 

    public static volatile SingularAttribute<SjaNovedad, Boolean> stsNovedad;
    public static volatile SingularAttribute<SjaNovedad, String> codUsuario;
    public static volatile SingularAttribute<SjaNovedad, String> txtNovedad;
    public static volatile SingularAttribute<SjaNovedad, Long> codUsrMod;
    public static volatile SingularAttribute<SjaNovedad, Long> idNovedad;
    public static volatile SingularAttribute<SjaNovedad, SjaNovedadId> id;
    public static volatile SingularAttribute<SjaNovedad, Date> fecUsrMod;

}