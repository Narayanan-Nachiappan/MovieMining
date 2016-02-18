package com.movie.mining.model;

import java.util.List;


//Unused as other fields arent too necessarty at this point of time
public class MovieModel {

	long id;

	int releaseYear;

	long utcTimeMilli;

	String providerCodes;

	List<Long> networkIds;

	Long latestNetworkId;

	String title;

	boolean isAlpha;

	enum dataA {
		h("HD"), n("new"), a("adult"), c("closed caption"), i("thumbnail Image");

		public String type;

		dataA(String type) {
			this.type = type;
		}
	};

	long videoId;

	enum entityType {
		MOVIE, TVSERIES
	};

	List<Integer> genereIds;

	int popularityIndex;

	char firstAlphabet;

	String href;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public long getUtcTimeMilli() {
		return utcTimeMilli;
	}

	public void setUtcTimeMilli(long utcTimeMilli) {
		this.utcTimeMilli = utcTimeMilli;
	}

	public String getProviderCodes() {
		return providerCodes;
	}

	public void setProviderCodes(String providerCodes) {
		this.providerCodes = providerCodes;
	}

	public List<Long> getNetworkIds() {
		return networkIds;
	}

	public void setNetworkIds(List<Long> networkIds) {
		this.networkIds = networkIds;
	}

	public Long getLatestNetworkId() {
		return latestNetworkId;
	}

	public void setLatestNetworkId(Long latestNetworkId) {
		this.latestNetworkId = latestNetworkId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAlpha() {
		return isAlpha;
	}

	public void setAlpha(boolean isAlpha) {
		this.isAlpha = isAlpha;
	}

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public List<Integer> getGenereIds() {
		return genereIds;
	}

	public void setGenereIds(List<Integer> genereIds) {
		this.genereIds = genereIds;
	}

	public int getPopularityIndex() {
		return popularityIndex;
	}

	public void setPopularityIndex(int popularityIndex) {
		this.popularityIndex = popularityIndex;
	}

	public char getFirstAlphabet() {
		return firstAlphabet;
	}

	public void setFirstAlphabet(char firstAlphabet) {
		this.firstAlphabet = firstAlphabet;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
