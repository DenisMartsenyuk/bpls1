package ru.lab.lab1.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.lab.lab1.dto.*;
import ru.lab.lab1.model.IMDBUser;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.model.Rating;
import ru.lab.lab1.repository.IMDBUserRepository;
import ru.lab.lab1.repository.RatingRepository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopMoviesGenerator {

    private final IMDBUserRepository userRepository;
    private final RatingRepository ratingRepository;

    public SendingEmailDTO generate() {
        List<String> emails = userRepository.getAllByEmailIsNotNull().stream().map(IMDBUser::getEmail).collect(Collectors.toList());
        List<Rating> ratings = ratingRepository.findRatingsByDateAfter(new Date(System.currentTimeMillis() - 7 * 86400000L));
        Map<Movie, Integer> ratedMovies = new HashMap<>();
        for (Rating rating : ratings) {
            Integer views = ratedMovies.get(rating.getMovie());
            if (views == null) {
                ratedMovies.put(rating.getMovie(), 1);
            } else {
                views++;
                ratedMovies.put(rating.getMovie(), views);
            }
        }
        List<Movie> topMovies = ratedMovies.entrySet().stream()
                .sorted(Map.Entry.<Movie, Integer> comparingByValue().reversed())
                .map(Map.Entry::getKey).collect(Collectors.toList());



        List<MovieRespDTO> topMoviesDTO = topMovies.stream()
                .limit(5)
                .map(this::getMovieRespDTO)
                .collect(Collectors.toList());

        return SendingEmailDTO.builder().emails(emails).movies(topMoviesDTO).build();
    }

    private MovieRespDTO getMovieRespDTO(Movie movie) {
        List<GenreRespDTO> genres =  movie.getGenres().stream()
                .map(x -> GenreRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());

        List<CountryRespDTO> countries = movie.getCountries().stream()
                .map(x -> CountryRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> directors = movie.getDirectors().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> writers = movie.getWriters().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> actors = movie.getActors().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());


        return MovieRespDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .description(movie.getDescription())
                .year(movie.getYear())
                .runtime(movie.getRuntime())
                .averageRating(movie.getAverageRating())
                .genres(genres)
                .countries(countries)
                .directors(directors)
                .writers(writers)
                .actors(actors)
                .build();
    }
}
