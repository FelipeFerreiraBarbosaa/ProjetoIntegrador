package projetointegrador.negocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> numeroEndereco;
	public static volatile SingularAttribute<Endereco, String> cepEndereco;
	public static volatile SingularAttribute<Endereco, Date> atualizacaoEndereco;
	public static volatile SingularAttribute<Endereco, Long> idEndereco;
	public static volatile SingularAttribute<Endereco, String> bairroEndereco;
	public static volatile SingularAttribute<Endereco, Date> criacaoEndereco;
	public static volatile SingularAttribute<Endereco, String> complementoEndereco;
	public static volatile SingularAttribute<Endereco, String> estadoEndereco;
	public static volatile SingularAttribute<Endereco, String> enderecoEndereco;
	public static volatile SingularAttribute<Endereco, String> cidadeEndereco;
	public static volatile SetAttribute<Endereco, Fornecedor> fornecedors;
	public static volatile SetAttribute<Endereco, Cliente> clientes;

}

