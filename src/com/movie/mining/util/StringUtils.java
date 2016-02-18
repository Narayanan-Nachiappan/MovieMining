/**
 * 
 */
package com.movie.mining.util;

import com.movie.mining.model.Movie;

/**
 * @author nnarayan
 * 
 */
public class StringUtils {

	/**
	 * @param line
	 * @return
	 */
	public static boolean isMovie(String line) {
		// TODO Auto-generated method stub
		if (line.contains("<a href")) {
			return true;
		} else {
			return false;
		}
	}

	public static String unEscape(String s) {
		return s.replaceAll("\"", "");
	}

}
