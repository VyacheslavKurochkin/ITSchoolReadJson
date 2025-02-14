package ru.kurochkin.readjson;

import ru.kurochkin.readjson.country.Country;
import ru.kurochkin.readjson.country.Currency;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static final String COUNTRIES_FILE_NAME = "src/main/java/ru/kurochkin/readjson/input/countries.json";
    private static final String EXEEDING_MILLION_POPULATION_COUNTRIES_FILE_NAME = "src/main/java/ru/kurochkin/readjson/output/resultCountries.json";
    private static final int POPULATION_LIMIT = 1000000;

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Country> countries = objectMapper.readValue(new File(COUNTRIES_FILE_NAME), new TypeReference<>() {});

            long populationsSum = countries.stream()
                    .filter(country -> country.getPopulation() != null)
                    .mapToLong(Country::getPopulation)
                    .sum();

            System.out.println("Сумма численности по странам: " + populationsSum);

            Map<String, List<Currency>> currenciesMap = countries.stream()
                    .flatMap(country -> country.getCurrencies().stream())
                    .filter(currency -> currency.getCode() != null && currency.getName() != null)
                    .collect(Collectors.groupingBy(Currency::getCode));

            List<Currency> currenciesList = currenciesMap.values()
                    .stream()
                    .map(List::getFirst)
                    .toList();

            System.out.println("Перечень всех валют: ");
            currenciesList.forEach(currency -> System.out.println(currency.getCode() + " - " + currency.getName()));

            List<Country> exeedingMillionPopulationCountriesList = countries.stream()
                    .filter(country -> country.getPopulation() != null && country.getPopulation() >= POPULATION_LIMIT)
                    .toList();

            try {
                File exeedingMillionPopulationCountriesFile = new File(EXEEDING_MILLION_POPULATION_COUNTRIES_FILE_NAME);

                if (!exeedingMillionPopulationCountriesFile.getParentFile().exists() && !exeedingMillionPopulationCountriesFile.getParentFile().mkdir()) {
                    throw new IOException("Ошибка при создании директории %s"
                            .formatted(EXEEDING_MILLION_POPULATION_COUNTRIES_FILE_NAME));
                }

                objectMapper.writeValue(exeedingMillionPopulationCountriesFile, exeedingMillionPopulationCountriesList);
                System.out.printf("Страны, где численность не менее 1 млн, сохранены в файл: \"%s\"",
                        EXEEDING_MILLION_POPULATION_COUNTRIES_FILE_NAME);
            } catch (IOException e) {
                System.out.printf("Ошибка при создании файла \"%s\": %s",
                        EXEEDING_MILLION_POPULATION_COUNTRIES_FILE_NAME, e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл \"%s\" не найден", COUNTRIES_FILE_NAME);
        } catch (UnrecognizedPropertyException e) {
            System.out.printf("При чтении файла \"%s\": обнаружено неизвестное поле %s", COUNTRIES_FILE_NAME, e.getMessage());
        } catch (IOException e) {
            System.out.printf("Ошибка при чтении файла \"%s\": %s", COUNTRIES_FILE_NAME, e.getMessage());
        }
    }
}