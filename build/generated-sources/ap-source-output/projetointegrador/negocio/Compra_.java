package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Compra.class)
public abstract class Compra_ {

	public static volatile SingularAttribute<Compra, Date> criacaoCompra;
	public static volatile SetAttribute<Compra, Pagamento> pagamentos;
	public static volatile SingularAttribute<Compra, Long> idCompra;
	public static volatile SingularAttribute<Compra, Date> atualizacaoCompra;
	public static volatile SingularAttribute<Compra, BigDecimal> valorCompra;
	public static volatile SingularAttribute<Compra, Date> vencimentoCompra;
	public static volatile SetAttribute<Compra, Itemcompra> itemcompras;
	public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Compra, Integer> parcelasCompra;

}

