package space.dubovitsky.portfolio.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum LanguageLevel {

	BEGINNER,
	
	ELEMENTARY,
	
	PRE_INTERMEDIATE,
	
	INTERMEDIATE,
	
	UPPER_INTERMEDIATE,
	
	ADVANCED,
	
	PROFICIENCY;
	
	public String getDbValue(){
		return name().toLowerCase();
	}

	/**
	 * Метод определяет, по каким правилам мы конвертируем объект из базы данных и в базу данных
	 */
	@Converter
	public static class LanguageLevelJpaConverter implements AttributeConverter<LanguageLevel, String> {

		@Override
		public String convertToDatabaseColumn(LanguageLevel languageLevel) {
			return languageLevel.getDbValue();
		}

		@Override
		public LanguageLevel convertToEntityAttribute(String s) {
			return LanguageLevel.valueOf(s.toUpperCase());
		}
	}
}
