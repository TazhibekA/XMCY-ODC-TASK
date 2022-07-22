package api;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Character {
	public String name;
	public String height;
	public String mass;
	public String hair_color;
	public String skin_color;
	public String eye_color;
	public String birth_year;
	public String gender;
	public String homeworld;
	public ArrayList<String> films;
	public ArrayList<Object> species;
	public ArrayList<String> vehicles;
	public ArrayList<String> starships;
	public Date created;
	public Date edited;
	public String url;

	@Override public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Character)) {
			return false;
		}
		Character character = (Character) o;
		return Objects.equals(name, character.name) && Objects.equals(height, character.height)
				&& Objects.equals(mass, character.mass) && Objects.equals(hair_color,
				character.hair_color) && Objects.equals(skin_color, character.skin_color)
				&& Objects.equals(eye_color, character.eye_color) && Objects.equals(birth_year,
				character.birth_year) && Objects.equals(gender, character.gender) && Objects.equals(
				homeworld, character.homeworld) && Objects.equals(films, character.films)
				&& Objects.equals(species, character.species) && Objects.equals(vehicles,
				character.vehicles) && Objects.equals(starships, character.starships) && Objects.equals(
				created, character.created) && Objects.equals(edited, character.edited)
				&& Objects.equals(url, character.url);
	}

	@Override public int hashCode() {
		return Objects.hash(name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld, films,
				species, vehicles, starships, created, edited, url);
	}

	@Override public String toString() {
		return "Character{" +
				"name='" + name + '\'' +
				", height='" + height + '\'' +
				", mass='" + mass + '\'' +
				", hair_color='" + hair_color + '\'' +
				", skin_color='" + skin_color + '\'' +
				", eye_color='" + eye_color + '\'' +
				", birth_year='" + birth_year + '\'' +
				", gender='" + gender + '\'' +
				", homeworld='" + homeworld + '\'' +
				", films=" + films +
				", species=" + species +
				", vehicles=" + vehicles +
				", starships=" + starships +
				", created=" + created +
				", edited=" + edited +
				", url='" + url + '\'' +
				'}';
	}
}
