/**
 * 
 */
package com.movie.mining.compare;

import java.util.Comparator;

import com.movie.mining.model.Movie;

/**
 * @author nnarayan
 * 
 */
public class MovieComparator implements Comparator<Movie> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Movie m1, Movie m2) {
		// TODO Auto-generated method stub
		if (m1.getPopularity() == m2.getPopularity()) {
			if (m1.getReleaseYear() == 0) {
				return -1;
			} else if (m2.getReleaseYear() == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return m1.getPopularity() - m2.getPopularity();
		}

	}

}
