package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

public class Starship {
	public String name;
	public String model;
	public String manufacturer;
	public String cost_in_credits;
	public String length;
	public String max_atmosphering_speed;
	public String crew;
	public String passengers;
	public String cargo_capacity;
	public String consumables;
	public String hyperdrive_rating;
	@JsonProperty("MGLT")
	public String mglt;
	public String starship_class;
	public ArrayList<String> pilots;
	public ArrayList<String> films;
	public Date created;
	public Date edited;
	public String url;

	@Override public String toString() {
		return "Starship{" +
				"name='" + name + '\'' +
				", model='" + model + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", cost_in_credits='" + cost_in_credits + '\'' +
				", length='" + length + '\'' +
				", max_atmosphering_speed='" + max_atmosphering_speed + '\'' +
				", crew='" + crew + '\'' +
				", passengers='" + passengers + '\'' +
				", cargo_capacity='" + cargo_capacity + '\'' +
				", consumables='" + consumables + '\'' +
				", hyperdrive_rating='" + hyperdrive_rating + '\'' +
				", mglt='" + mglt + '\'' +
				", starship_class='" + starship_class + '\'' +
				", pilots=" + pilots +
				", films=" + films +
				", created=" + created +
				", edited=" + edited +
				", url='" + url + '\'' +
				'}';
	}
}
