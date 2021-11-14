package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, BigDecimal> limiteCliente;
	public static volatile SingularAttribute<Cliente, String> cpfCliente;
	public static volatile SingularAttribute<Cliente, Long> idCliente;
	public static volatile SingularAttribute<Cliente, Endereco> endereco;
	public static volatile SetAttribute<Cliente, Venda> vendas;
	public static volatile SingularAttribute<Cliente, BigDecimal> descontoCliente;
	public static volatile SingularAttribute<Cliente, String> nomeCliente;
	public static volatile SingularAttribute<Cliente, Date> atualizacaoCliente;
	public static volatile SingularAttribute<Cliente, Contato> contato;
	public static volatile SingularAttribute<Cliente, Date> criacaoCliente;

}

