package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pagamento.class)
public abstract class Pagamento_ {

	public static volatile SingularAttribute<Pagamento, Boolean> statusPagamento;
	public static volatile SingularAttribute<Pagamento, Compra> compra;
	public static volatile SingularAttribute<Pagamento, Long> idPagamento;
	public static volatile SingularAttribute<Pagamento, Lancamento> lancamento;
	public static volatile SingularAttribute<Pagamento, Date> dataPagamento;
	public static volatile SingularAttribute<Pagamento, Date> criacaoPagamento;
	public static volatile SingularAttribute<Pagamento, Date> atualizacaoPagamento;
	public static volatile SingularAttribute<Pagamento, BigDecimal> valorPagamento;
	public static volatile SingularAttribute<Pagamento, String> descricaoPagamento;

}

