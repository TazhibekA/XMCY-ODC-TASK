package api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import java.util.ArrayList;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests {
	String baseUrl = "https://swapi.dev/api";
	Root root;
	Character character;
	Starship starship;
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void validate()
	{
		root =
		given()
				.when()
				.queryParam("search","A New Hope")
				.get(baseUrl+ "/films/")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.as(Root.class);
		System.out.println(root.toString());

		ArrayList<String> characters = root.results.get(0).characters;
		for (String characterEndpoint : characters){
			character =
			when()
					.get(characterEndpoint)
					.then()
					.contentType(ContentType.JSON)
					.extract()
					.as(Character.class);
			if(character.name.equals("Biggs Darklighter")){
				break;
			}
		}
		System.out.println(character.toString());

		String starshipEndpoint = character.starships.get(0);
		starship =
				when()
						.get(starshipEndpoint)
						.then()
						.contentType(ContentType.JSON)
						.extract()
						.as(Starship.class);
		softAssert.assertEquals(starship.starship_class,"Starfighter","Starship class is  not Starfighter!");

		boolean isPilotPresent = false;
		ArrayList<String> pilots = starship.pilots;
		for (String pilotEndpoint : pilots){
			character =
					when()
							.get(pilotEndpoint)
							.then()
							.contentType(ContentType.JSON)
							.extract()
							.as(Character.class);
			if(character.name.equals("Luke Skywalker")){
				isPilotPresent = true;
			}
		}
		softAssert.assertTrue(isPilotPresent,"Luke Skywalker is not among pilots of this starship!");
		softAssert.assertAll();
	}

}
