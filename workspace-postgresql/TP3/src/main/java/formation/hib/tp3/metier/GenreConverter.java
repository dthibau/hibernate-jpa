package formation.hib.tp3.metier;

import javax.persistence.AttributeConverter;

public class GenreConverter implements AttributeConverter<Genre, String> {

	@Override
	public String convertToDatabaseColumn(Genre attribute) {
		switch (attribute) {
		case FEMME:
			return "F";
		case HOMME:
			return "M";
		}
		return null;
	}

	@Override
	public Genre convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			switch (dbData) {
			case "F":
				return Genre.FEMME;
			case "M":
				return Genre.HOMME;
			}
		}
		return null;
	}

}
