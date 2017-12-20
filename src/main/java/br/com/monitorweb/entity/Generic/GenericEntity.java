package br.com.monitorweb.entity.Generic;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Classe base para qualquer objeto serializável.
 *
 * @author Eduardo Balan
 *
 * @param <T> o tipo do atributo id
 */
public abstract class GenericEntity<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract T getId();

    public abstract void setId(T id);

    public abstract Date getDthr_cadastro();

    public abstract void setDthr_cadastro(Date date);

    /**
     * Indica quando outro objeto é igual a este. Nesta implementação, qualquer objeto derivado de
     * Bean é igual a este desde que seja exatamente da mesma classe e tenha o mesmo ID. Caso
     * precise de outra lógica, sobrescreva este método.
     *
     * @author Kleber Kruger
     *
     * @param obj o objeto a comparar com este
     * @return {@code true} se este objeto é igual ao do argumento; {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (getId() != null && obj instanceof GenericEntity) {
            GenericEntity x = (GenericEntity) obj;
            return getClass() == x.getClass() && getId().equals(x.getId());
        }
        return super.equals(obj);
    }

    /**
     * Retorna um valor de hash code para este objeto. Nesta implementação, este valor é gerado por
     * uma combinação do hash code da classe (getClass().hashCode()) somado ao hash code do atributo
     * id (id.hashCode()).
     *
     * Classes semelhantes terão o mesmo valor base de hash code, que quando somado ao hash code do
     * id, terá o valor: valorBaseHashCodeClasse + idHashCode. Por exemplo, se o valor base do hash
     * code da classe {@code Cachorro} é 300 e o objeto {@code Cachorro c1} tem o id = 1, o retorno
     * deste método será 301.
     *
     * @author Kleber Kruger
     *
     * @return um valor de hash code para este objeto
     */
    @Override
    public int hashCode() {
        if (getId() != null) {
            return 43 * 7 + Objects.hashCode(getClass().hashCode() + getId().hashCode());
        }
        return super.hashCode();
    }


}
