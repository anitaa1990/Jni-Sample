package com.an.moviesample.model

import java.io.Serializable
import java.util.Arrays

class Movie(val name: String,
            val description: String,
            val releaseDate: String,
            val posterUrl: String,
            val status: String,
            val runtime: Long,
            var lastUpdate: Int,
            private val videos: String,
            private val genres: String) : Serializable {

    fun getVideoList(): List<String> {
        return Arrays.asList(*videos.split(",").map { it.trim() }.toTypedArray())
    }

    fun getGenreList(): List<String> {
        return Arrays.asList(*genres.split(",").map { it.trim() }.toTypedArray())
    }
}
