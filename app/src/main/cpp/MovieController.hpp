//
//  MovieController.hpp
//  Highrise
//
//  Created by Jimmy Xu on 12/19/18.
//  Copyright © 2019 Highrise. All rights reserved.
//

#ifndef MovieController_hpp
#define MovieController_hpp

#include <string>
#include <vector>
#include <map>

namespace movies {
    class Actor {
    public:
        std::string name;
        int age;

        //optional challenge 1: Load image from URL
        std::string imageUrl;
    };

    class Movie {
    public:
        std::string name;
        std::string description;
        std::string releaseDate;
        std::string posterUrl;
        std::string status;
        int lastUpdated;
        long runtime;
        std::string videos;
        std::string genres;
    };

    class MovieDetail {
    public:
        std::string name;
        float score;
        std::vector<Actor> actors;
        std::string description;
    };

    class MovieController {
    private:
        std::vector<Movie*> _movies;
        std::map<std::string, MovieDetail*> _details;

    public:
        MovieController() {
            //populate data
            auto movie1 = new Movie();
            movie1->name = "Aquaman";
            movie1->posterUrl = "https://image.tmdb.org/t/p/w500/i2dF9UxOeb77CAJrOflj0RpqJRF.jpg";
            movie1->videos = "WDkg3h8PCVU, WaWnLiffxJ4, shdb-Bn-kMo, 2wcj6SrX4zw";
            movie1->description = "Arthur Curry learns that he is the heir to the underwater kingdom of Atlantis, and must step forward to lead his people and be a hero to the world.";
            movie1->releaseDate = "2018-12-21";
            movie1->runtime = 143;
            movie1->status = "Released";
            movie1->genres = "Action, Fantasy, Science Fiction, Adventure";
            _movies.push_back(movie1);


            auto movie2 = new Movie();
            movie2->name = "Bumblebee";
            movie2->posterUrl = "https://image.tmdb.org/t/p/w500/fw02ONlDhrYjTSZV8XO6hhU3ds3.jpg";
            movie2->videos = "fAIX12F6958, lcwmDAYt22k, T1Zeoj3twHk, 2wcj6SrX4zw";
            movie2->description = "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.";
            movie2->releaseDate = "2018-12-15";
            movie2->runtime = 114;
            movie2->status = "Released";
            movie2->genres = "Action, Science Fiction, Adventure";
            _movies.push_back(movie2);


            auto movie3 = new Movie();
            movie3->name = "Bird Box";
            movie3->posterUrl = "https://image.tmdb.org/t/p/w500/rGfGfgL2pEPCfhIvqHXieXFn7gp.jpg";
            movie3->videos = "o2AsIXSh2xo";
            movie3->description = "When a mysterious force decimates the world’s population, only one thing is certain: if you see it, you take your life. Facing the unknown, Malorie finds love, hope and a new beginning only for it to unravel. Now she must flee with her two children down a treacherous river to the one place left that may offer sanctuary. But to survive, they'll have to undertake the perilous two-day journey blindfolded.";
            movie3->releaseDate = "2018-12-13";
            movie3->runtime = 124;
            movie3->status = "Released";
            movie3->genres = "Thriller, Drama, Science Fiction, Horror";
            _movies.push_back(movie3);

            auto movie4 = new Movie();
            movie4->name = "Venom";
            movie4->posterUrl = "https://image.tmdb.org/t/p/w500/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg";
            movie4->videos = "dzxFdtWmjto, MDR3bfmzV8c, u9Mv98Gr5pY, xLCn88bfW1o";
            movie4->description = "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.";
            movie4->releaseDate = "2018-10-03";
            movie4->runtime = 112;
            movie4->status = "Released";
            movie4->genres = "Science Fiction";
            _movies.push_back(movie4);

            auto movie5 = new Movie();
            movie5->name = "Mary Poppins Returns";
            movie5->posterUrl = "https://image.tmdb.org/t/p/w500/uTVGku4LibMGyKgQvjBtv3OYfAX.jpg";
            movie5->videos = "PzcaR1N0pTI, -3jsfXDZLIY, fKfvc0gbTBk, BbQQ6DzmpFE";
            movie5->description = "In Depression-era London, a now-grown Jane and Michael Banks, along with Michael's three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives.";
            movie5->releaseDate = "2018-12-19";
            movie5->runtime = 131;
            movie5->status = "Released";
            movie5->genres = "Fantasy, Music, Family, Comedy";
            _movies.push_back(movie5);

            auto movie6 = new Movie();
            movie6->name = "Fantastic Beasts: The Crimes of Grindelwald";
            movie6->posterUrl = "https://image.tmdb.org/t/p/w500/kQKcbJ9uYkTQql2R8L4jTUz7l90.jpg";
            movie6->videos = "5sEaYB4rLFQ, vvFybpmyB9E, 8bYBOVWLNIs, U0YyQ9TGQa0, _dVmXhXFI6o, DwfO-pLonAY, 9M2QMIio8sY, DCfCA92Eifk";
            movie6->description = "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.";
            movie6->releaseDate = "2018-11-14";
            movie6->runtime = 134;
            movie6->status = "Released";
            movie6->genres = "Family, Fantasy, Adventure";
            _movies.push_back(movie6);

            auto movie7 = new Movie();
            movie7->name = "The Mule";
            movie7->posterUrl = "https://image.tmdb.org/t/p/w500/t0idiLMalKMj2pLsvqHrOM4LPdQ.jpg";
            movie7->videos = "N_QksSzK7sI";
            movie7->description = "A 90-year-old horticulturalist and Korean War veteran is caught transporting $3 million worth of cocaine through Illinois for a Mexican drug cartel.";
            movie7->releaseDate = "2018-12-14";
            movie7->runtime = 116;
            movie7->status = "Released";
            movie7->genres = "Crime, Drama, Thriller";
            _movies.push_back(movie7);

            auto movie8 = new Movie();
            movie8->name = "Spider-Man: Into the Spider-Verse";
            movie8->posterUrl = "https://image.tmdb.org/t/p/w500/laMM4lpQSh5z6KIBPwWogkjzBVQ.jpg";
            movie8->videos = "g4Hbz2jLxvQ, ii3n7hYQOl4, tg52up16eq0, jGzhm6g6BO4";
            movie8->description = "Miles Morales is juggling his life between being a high school student and being Spider-Man. However, when Wilson \"Kingpin\" Fisk uses a super collider, another Spider-Man from another dimension, Peter Parker, accidentally winds up in Miles' dimension. As Peter trains Miles to become a better Spider-Man, they are soon joined by four other Spider-Men from across the \"Spider-Verse\". As all these clashing dimensions start to tear Brooklyn apart, Miles must help the others stop Fisk and return everyone to their own dimensions.";
            movie8->releaseDate = "2018-12-07";
            movie8->runtime = 117;
            movie8->status = "Released";
            movie8->genres = "Action, Animation, Science Fiction, Adventure, Comedy";
            _movies.push_back(movie8);

            auto movie9 = new Movie();
            movie9->name = "Ralph Breaks the Internet";
            movie9->posterUrl = "https://image.tmdb.org/t/p/w500/8GCoHKfNe4kK0yWhJDYKyM7Zbxk.jpg";
            movie9->videos = "_BcYBFC6zfY, DIBw9dSVKdU, T73h5bmD8Dc, oc96aHppNIM";
            movie9->description = "Six years after the events of \"Wreck-It Ralph,\" Ralph and Vanellope, now friends, discover a wi-fi router in their arcade, leading them into a new adventure.";
            movie9->releaseDate = "2018-11-20";
            movie9->runtime = 112;
            movie9->status = "Released";
            movie9->genres = "Animation, Fantasy, Family, Comedy";
            _movies.push_back(movie9);

            auto movie10 = new Movie();
            movie10->name = "Creed II";
            movie10->posterUrl = "https://image.tmdb.org/t/p/w500/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg";
            movie10->videos = "cPNVNqn4T9I, pNjk91ATS-Y";
            movie10->description = "Follows Adonis Creed's life inside and outside of the ring as he deals with new found fame, issues with his family, and his continuing quest to become a champion.";
            movie10->releaseDate = "2018-11-20";
            movie10->runtime = 130;
            movie10->status = "Released";
            movie10->genres = "Drama, Action";
            _movies.push_back(movie10);
        }

        //Returns list of movies
        std::vector<Movie*> getMovies() {
            return _movies;
        }

        //Returns details about a specific movie
        MovieDetail* getMovieDetail(std::string name) {
            for (auto item:_details) {
                if (item.second->name == name) {
                    return item.second;
                }
            }
            return nullptr;
        }
    };
}

#endif /* MovieController_hpp */