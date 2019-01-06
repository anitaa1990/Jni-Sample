package com.an.moviesample.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Movie implements Serializable {

    private String name;
    private String description;
    private String releaseDate;
    private String posterUrl;
    private String status;
    private long runtime;
    private int lastUpdated;
    private String videos;
    private String genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<String> getVideoList() {
        return Arrays.asList(videos.split("\\s*,\\s*"));
    }

    public List<String> getGenreList() {
        return Arrays.asList(genres.split("\\s*,\\s*"));
    }
}
