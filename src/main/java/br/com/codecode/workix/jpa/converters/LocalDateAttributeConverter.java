package br.com.codecode.workix.jpa.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * FIXME causing:  AttributeConverter: Unable to instantiate exception
 * @see <a href=
 *      "http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa">
 *      Persist LocalDate LocalDateTime</a>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
// @Converter(autoApply = true)
class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
	return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
