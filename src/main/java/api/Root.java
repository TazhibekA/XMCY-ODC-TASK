package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Objects;

public class Root {
	@JsonProperty("count")
	public int count;
	@JsonProperty("next")
	public Object next;
	@JsonProperty("previous")
	public Object previous;
	@JsonProperty("results")
	public ArrayList<Result> results;

	@Override public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Root)) {
			return false;
		}
		Root root = (Root) o;
		return count == root.count && Objects.equals(next, root.next) && Objects.equals(previous,
				root.previous) && Objects.equals(results, root.results);
	}

	@Override public int hashCode() {
		return Objects.hash(count, next, previous, results);
	}

	@Override public String toString() {
		return "Root{" +
				"count=" + count +
				", next=" + next +
				", previous=" + previous +
				", results=" + results +
				'}';
	}

	public Result getFilmByTitle(String title){
		for (Result result : results){
			if(result.title.equals(title)){
				return result;
			}
		}
		return null;
	}
}
