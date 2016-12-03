package br.com.codecode.workix.core.models.jdk8.root;

import java.time.LocalDate;

import br.com.codecode.workix.core.models.jdk8.actions.EducationActions;

/**
 * Root Abstract Class Education<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #schoolName}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #qualification}</li>
 * <li>{@link #description}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see EducationActions
 */
public abstract class BaseEducation implements EducationActions {

    /**
     * School Name Field
     */
    protected String schoolName;

    /**
     * Start Date Field
     */
    protected LocalDate startDate;

    /**
     * End Date Field
     */
    protected LocalDate endDate;

    /**
     * Qualification Field
     */
    protected String qualification;

    /**
     * Description Field
     */
    protected String description;

}