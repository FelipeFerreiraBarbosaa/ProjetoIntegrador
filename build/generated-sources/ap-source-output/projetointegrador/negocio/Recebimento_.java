package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recebimento.class)
public abstract class Recebimento_ {

	public static volatile SingularAttribute<Recebimento, Venda> venda;
	public static volatile SingularAttribute<Recebimento, BigDecimal> valorRecebimento;
	public static volatile SingularAttribute<Recebimento, Long> idRecebimento;
	public static volatile SingularAttribute<Recebimento, Lancamento> lancamento;
	public static volatile SingularAttribute<Recebimento, Boolean> statusRecebimento;
	public static volatile SingularAttribute<Recebimento, Date> criacaoRecebimento;
	public static volatile SingularAttribute<Recebimento, String> descricaoRecebimento;
	public static volatile SingularAttribute<Recebimento, Date> dataRecebimento;
	public static volatile SingularAttribute<Recebimento, Date> atualizacaoRecebimento;

}

