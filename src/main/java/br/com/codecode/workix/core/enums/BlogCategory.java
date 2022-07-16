package br.com.codecode.workix.core.enums;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Blog Categories Enumeration
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
@Persist
public enum BlogCategory {
    COMPANIES, JOBS, RESUMES, MARKET
}
