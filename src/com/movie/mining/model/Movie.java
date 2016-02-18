/**
 * 
 */
package com.movie.mining.model;

import java.util.ArrayList;
import java.util.List;

import com.movie.mining.util.StringUtils;

/**
 * @author nnarayan
 * 
 */
public class Movie implements Comparable<Movie> {

	long id;

	int popularity;

	String title;

	int releaseYear;

	List<Long> genreIds;

	public List<Long> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Long> genreIds) {
		this.genreIds = genreIds;
	}

	public static enum EntityType {
		MOVIE, TVSERIES
	};

	EntityType entity;

	public EntityType getEntity() {
		return entity;
	}

	public void setEntity(EntityType entity) {
		this.entity = entity;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param line
	 * @return
	 */
	public static Movie fromMovie(String line) {
		// TODO Auto-generated method stub
		// TODO move all string functions to string util
		String lineArr[] = line.split(" ");
		List<Long> genreIds = new ArrayList<>();
		Movie m = new Movie();

		m.setTitle(line.split("</a>")[0].split(">")[1]);
		// TODO move all string functions to string util
		if (line.contains("id")) {
			m.setId(new Long(StringUtils.unEscape(line.split("id=")[1]
					.split(" ")[0])));
		}
		// TODO move all string functions to string util
		if (line.contains("data-rl")) {
			m.setReleaseYear(new Integer(StringUtils.unEscape(line
					.split("data-rl=")[1].split(" ")[0])));
		}
		// TODO move all string functions to string util
		if (line.contains("data-pop")) {
			m.setPopularity(new Integer(StringUtils.unEscape(line
					.split("data-pop=")[1].split(" ")[0])));
		}
		// TODO move all string functions to string util
		if (line.contains("data-type")) {
			String entity = StringUtils.unEscape(line.split("data-type=")[1]
					.split(" ")[0]);
			m.setEntity(EntityType.valueOf(entity.toUpperCase()));
		}
		// TODO move all string functions to string util
		if (line.contains("data-g")) {
			String genres = StringUtils.unEscape(line.split("data-g=")[1]
					.split(" data")[0]);
			if (genres.contains(" ")) {
				String[] genreArr = genres.split(" ");
				for (String s : genreArr) {
					genreIds.add(new Long(s));
				}
			} else {
				genreIds.add(new Long(genres));
			}
		}
		m.setGenreIds(genreIds);
		return m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Movie m2) {
		// TODO Auto-generated method stub
		if (m2.getPopularity() == this.getPopularity()) {
			if (this.getReleaseYear() == 0) {
				return 1;
			} else if (m2.getReleaseYear() == 0) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return m2.getPopularity() - this.getPopularity();
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Movie :");
		sb.append(title).append(" ");
		if (releaseYear != 0) {
			sb.append("(" + releaseYear + ")");
		}
		sb.append(", " + popularity);
		return sb.toString();

	}
}
