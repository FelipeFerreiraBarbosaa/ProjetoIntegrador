package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, BigDecimal> vendaProduto;
	public static volatile SingularAttribute<Produto, Date> atualizacaoProduto;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
	public static volatile SingularAttribute<Produto, Long> maximoProduto;
	public static volatile SingularAttribute<Produto, String> descricaoProduto;
	public static volatile SingularAttribute<Produto, Date> criacaoProduto;
	public static volatile SingularAttribute<Produto, Long> estoqueProduto;
	public static volatile SingularAttribute<Produto, Long> idProduto;
	public static volatile SetAttribute<Produto, Itemvenda> itemvendas;
	public static volatile SingularAttribute<Produto, Long> minimoProduto;
	public static volatile SingularAttribute<Produto, String> codigoProduto;
	public static volatile SetAttribute<Produto, Itemcompra> itemcompras;
	public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Produto, BigDecimal> custoProduto;

}

