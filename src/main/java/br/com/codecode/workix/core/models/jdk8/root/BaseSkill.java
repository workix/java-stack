package br.com.codecode.workix.core.models.jdk8.root;

import br.com.codecode.workix.core.models.jdk8.actions.SkillActions;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #skillName}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see SkillActions
 */
public abstract class BaseSkill implements SkillActions {

    /**
     * Name of Skill Field
     */
    protected String skillName;   

}