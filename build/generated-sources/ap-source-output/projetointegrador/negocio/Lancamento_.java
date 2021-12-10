package projetointegrador.negocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

	public static volatile SingularAttribute<Lancamento, String> tipoLancamento;
	public static volatile SetAttribute<Lancamento, Pagamento> pagamentos;
	public static volatile SingularAttribute<Lancamento, Date> criacaoLancamento;
	public static volatile SingularAttribute<Lancamento, Long> idLancamento;
	public static volatile SingularAttribute<Lancamento, Date> atualizacaLancamento;
	public static volatile SetAttribute<Lancamento, Recebimento> recebimentos;

}

