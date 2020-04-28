package space.dubovitsky.portfolio.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum LanguageType {

	ALL,

	SPOKEN,

	WRITING;
	
	public String getDbValue() {
		return name().toLowerCase();
	}

	public LanguageType getReverseType() {
		if (this == SPOKEN) {
			return WRITING;
		} else if (this == WRITING) {
			return SPOKEN;
		} else {
			throw new IllegalArgumentException(this + " does not have reverse type");
		}
	}

	@Converter
	public static class LanguageTypeJpaConverter implements AttributeConverter<LanguageType, String> {

		@Override
		public String convertToDatabaseColumn(LanguageType languageType) {
			return languageType.getDbValue();
		}

		@Override
		public LanguageType convertToEntityAttribute(String s) {
			return LanguageType.valueOf(s.toUpperCase());
		}
	}
}
