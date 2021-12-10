package projetointegrador.negocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contato.class)
public abstract class Contato_ {

	public static volatile SingularAttribute<Contato, String> emailContato;
	public static volatile SingularAttribute<Contato, String> celularContato;
	public static volatile SingularAttribute<Contato, String> nomeContato;
	public static volatile SingularAttribute<Contato, Long> idContato;
	public static volatile SingularAttribute<Contato, Date> criacaoContato;
	public static volatile SetAttribute<Contato, Fornecedor> fornecedors;
	public static volatile SetAttribute<Contato, Cliente> clientes;
	public static volatile SingularAttribute<Contato, String> telefoneContato;
	public static volatile SingularAttribute<Contato, Date> atualizacaoContato;

}

