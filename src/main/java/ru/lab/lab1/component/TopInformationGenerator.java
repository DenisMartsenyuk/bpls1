package ru.lab.lab1.component;

import org.springframework.stereotype.Component;
import ru.lab.lab1.dto.MovieRespDTO;

import java.util.List;

@Component
public class TopInformationGenerator {
    public String generate(List<MovieRespDTO> moviesDto) {
        StringBuilder informationBuilder = new StringBuilder();
        for (int i = 0; i < moviesDto.size(); ++i) {
            informationBuilder.append(i + 1).append(" место:\n").append(getInformationMovie(moviesDto.get(i))).append("\n");
        }
        return informationBuilder.toString();
    }

    private String getInformationMovie(MovieRespDTO movieRespDTO) {
        String information = "";
        information = information + "Название: " + movieRespDTO.getName() + "\n";
        information = information + "Описание: " + movieRespDTO.getDescription() + "\n";
        information = information + "Год: " + movieRespDTO.getYear() + "\n";
        information = information + "Продолжительность: " + movieRespDTO.getRuntime() + "\n";
        information = information + "Рейтинг: " + movieRespDTO.getAverageRating() + "\n";

        StringBuilder stringBuilder = new StringBuilder();
        movieRespDTO.getGenres().forEach(x -> stringBuilder.append(x.getName()).append(" "));
        information = information + "Жанры: " + stringBuilder + "\n";
        stringBuilder.setLength(0);

        movieRespDTO.getDirectors().forEach(x -> stringBuilder.append(x.getName()).append(" ").append(x.getSurname()).append(" "));
        information = information + "Режисеры: " + stringBuilder + "\n";
        stringBuilder.setLength(0);

        movieRespDTO.getWriters().forEach(x -> stringBuilder.append(x.getName()).append(" ").append(x.getSurname()).append(" "));
        information = information + "Сценаристы: " + stringBuilder + "\n";
        stringBuilder.setLength(0);

        movieRespDTO.getActors().forEach(x -> stringBuilder.append(x.getName()).append(" ").append(x.getSurname()).append(" "));
        information = information + "Актеры: " + stringBuilder + "\n";
        stringBuilder.setLength(0);

        return information + "\n";
    }
}
