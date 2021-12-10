package projetointegrador.negocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile SetAttribute<Fornecedor, Compra> compras;
	public static volatile SingularAttribute<Fornecedor, Long> idFornecedor;
	public static volatile SingularAttribute<Fornecedor, Endereco> endereco;
	public static volatile SingularAttribute<Fornecedor, String> nomeFornecedor;
	public static volatile SetAttribute<Fornecedor, Produto> produtos;
	public static volatile SingularAttribute<Fornecedor, String> cnpjFornecedor;
	public static volatile SingularAttribute<Fornecedor, Contato> contato;
	public static volatile SingularAttribute<Fornecedor, Date> criacaoFornecedor;
	public static volatile SingularAttribute<Fornecedor, Date> atualizacaoFornecedor;

}

