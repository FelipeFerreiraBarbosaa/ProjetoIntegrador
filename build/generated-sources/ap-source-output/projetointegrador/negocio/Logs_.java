package projetointegrador.negocio;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Logs.class)
public abstract class Logs_ {

	public static volatile SingularAttribute<Logs, Integer> log_id;
	public static volatile SingularAttribute<Logs, String> level;
	public static volatile SingularAttribute<Logs, String> logger;
	public static volatile SingularAttribute<Logs, Calendar> dated;
	public static volatile SingularAttribute<Logs, String> message;
	public static volatile SingularAttribute<Logs, String> username;

}

