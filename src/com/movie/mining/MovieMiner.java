/**
 * 
 */
package com.movie.mining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.movie.mining.compare.GenreComparator;
import com.movie.mining.model.Genre;
import com.movie.mining.model.Movie;
import com.movie.mining.util.StringUtils;

/**
 * @author nnarayan
 * 
 */
public class MovieMiner {

	public static final String INPUT_FILE = "resources/moviedata.txt";

	Map<Long, Genre> genrePopularity;
	Map<Long, Movie> movieData;
	TreeSet<Genre> orderedGenre;
	Map<Long, TreeSet<Movie>> orderedMovieToGenre;
	TreeSet<Movie> noGenreMovies;

	/**
	 * 
	 */
	public MovieMiner() {
		genrePopularity = new HashMap<>();
		movieData = new HashMap<>();
		orderedGenre = new TreeSet<Genre>(new GenreComparator());
		orderedMovieToGenre = new HashMap<>();
		noGenreMovies = new TreeSet<>();
	}

	private void processInputFile() {

		try {
			InputStreamReader reader = new InputStreamReader(this.getClass()
					.getClassLoader().getResourceAsStream(INPUT_FILE));
			BufferedReader br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null) {
				if (StringUtils.isMovie(line)) {
					Movie m = Movie.fromMovie(line);
					movieData.put(m.getId(), m);
					if (m.getGenreIds().size() > 0) {
						processMovieAndGenre(m);
					} else {
						noGenreMovies.add(m);
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void outputOrderedMovies() {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File("output.txt"));
			bw = new BufferedWriter(fw);
			bw.write(("Total Movies " + movieData.size()));
			bw.write(System.getProperty("line.separator"));
			bw.write("Total Genre " + genrePopularity.size());
			bw.write(System.getProperty("line.separator"));
			Iterator<Genre> genreIter = orderedGenre.iterator();
			while (genreIter.hasNext()) {
				Genre gen = genreIter.next();
				if (gen.getPopularity() > 0) {
					bw.write(gen.toString());
					bw.write(System.getProperty("line.separator"));
					TreeSet<Movie> movieSet = orderedMovieToGenre.get(gen
							.getGenreId());
					if (movieSet != null) {
						for (Movie m : movieSet) {
							if (m.getPopularity() > 0)
								bw.write(m.toString());
							bw.write(System.getProperty("line.separator"));
						}
					}
				}
			}
			bw.write("== No Genre ==");
			bw.write(System.getProperty("line.separator"));
			Iterator<Movie> movieIter = noGenreMovies.iterator();
			while (movieIter.hasNext()) {
				Movie m = movieIter.next();
				if (m.getPopularity() > 0) {
					bw.write(m.toString());
					bw.write(System.getProperty("line.separator"));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @param m
	 */
	private void processMovieAndGenre(Movie m) {
		// TODO Auto-generated method stub
		if (m.getEntity() == Movie.EntityType.MOVIE) {
			processGenre(m);
			processMovie(m);
		} else {
			return;
		}

	}

	/**
	 * @param m
	 */
	private void processMovie(Movie m) {
		// TODO Auto-generated method stub

		for (Long genreId : m.getGenreIds()) {

			if (orderedMovieToGenre.containsKey(genreId)) {
				orderedMovieToGenre.get(genreId).add(m);
			} else {
				TreeSet<Movie> movieSet = new TreeSet<>();
				movieSet.add(m);
				orderedMovieToGenre.put(genreId, movieSet);

			}
		}
	}

	/**
	 * @param m
	 */
	private void processGenre(Movie m) {
		// TODO Auto-generated method stub
		for (Long genreId : m.getGenreIds()) {
			if (genreId == 6988172973376731127l) {
				System.err.println();
			}
			if (genrePopularity.containsKey(genreId)) {
				Genre g = genrePopularity.get(genreId);
				if (m.getPopularity() > g.getPopularity()) {
					orderedGenre.remove(g);
					Genre readdGenre = new Genre(genreId, m.getPopularity());
					orderedGenre.add(readdGenre);
					genrePopularity.put(genreId, readdGenre);
				}
			} else {
				Genre g = new Genre(genreId, m.getPopularity());
				genrePopularity.put(genreId, g);
				orderedGenre.add(g);
			}
		}
	}

	public static void main(String a[]) {
		MovieMiner invoker = new MovieMiner();
		invoker.processInputFile();
		invoker.outputOrderedMovies();
	}

}
