/**
 * 
 */
package com.movie.mining.compare;

import java.util.Comparator;

import com.movie.mining.model.Genre;

/**
 * @author nnarayan
 * 
 */
public class GenreComparator implements Comparator<Genre> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Genre g1, Genre g2) {
		// TODO Auto-generated method stub
		if (g2.getPopularity() == g1.getPopularity()) {
			return (int) (g2.getGenreId() - g1.getGenreId());
		} else {
			return g2.getPopularity() - g1.getPopularity();
		}
	}

}
