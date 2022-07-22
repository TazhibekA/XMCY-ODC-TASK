package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Result {
	@JsonProperty("title")
	public String title;
	@JsonProperty("episode_id")
	public int episode_id;
	@JsonProperty("opening_crawl")
	public String opening_crawl;
	@JsonProperty("director")
	public String director;
	@JsonProperty("producer")
	public String producer;
	@JsonProperty("release_date")
	public String release_date;
	@JsonProperty("characters")
	public ArrayList<String> characters;
	@JsonProperty("planets")
	public ArrayList<String> planets;
	@JsonProperty("starships")
	public ArrayList<String> starships;
	@JsonProperty("vehicles")
	public ArrayList<String> vehicles;
	@JsonProperty("species")
	public ArrayList<String> species;
	@JsonProperty("created")
	public Date created;
	@JsonProperty("edited")
	public Date edited;
	@JsonProperty("url")
	public String url;

	@Override public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Result)) {
			return false;
		}
		Result result = (Result) o;
		return episode_id == result.episode_id && Objects.equals(title, result.title) && Objects.equals(
				opening_crawl, result.opening_crawl) && Objects.equals(director, result.director)
				&& Objects.equals(producer, result.producer) && Objects.equals(release_date,
				result.release_date) && Objects.equals(characters, result.characters) && Objects.equals(
				planets, result.planets) && Objects.equals(starships, result.starships)
				&& Objects.equals(vehicles, result.vehicles) && Objects.equals(species, result.species)
				&& Objects.equals(created, result.created) && Objects.equals(edited, result.edited)
				&& Objects.equals(url, result.url);
	}

	@Override public int hashCode() {
		return Objects.hash(title, episode_id, opening_crawl, director, producer, release_date, characters, planets,
				starships, vehicles, species, created, edited, url);
	}

	@Override public String toString() {
		return "Result{" +
				"title='" + title + '\'' +
				", episode_id=" + episode_id +
				", opening_crawl='" + opening_crawl + '\'' +
				", director='" + director + '\'' +
				", producer='" + producer + '\'' +
				", release_date='" + release_date + '\'' +
				", characters=" + characters +
				", planets=" + planets +
				", starships=" + starships +
				", vehicles=" + vehicles +
				", species=" + species +
				", created=" + created +
				", edited=" + edited +
				", url='" + url + '\'' +
				'}';
	}
}
