package br.com.codecode.workix.model.base;

/**
 * Root Abstract Class Company<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cnpj}</li>
 * <li>{@link #segment}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BasePerson
 */
public abstract class BaseCompany extends BasePerson {

    protected long cnpj;

    protected String segment;
}
