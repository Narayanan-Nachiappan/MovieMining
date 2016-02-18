/**
 * 
 */
package com.movie.mining.model;

/**
 * @author nnarayan
 * 
 */
public class Genre {

	long genreId;

	int popularity;

	public Genre(long id, int popularity) {
		this.genreId = id;
		this.popularity = popularity;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String toString() {
		return "Genre : " + genreId + ", " + popularity;
	}

}
