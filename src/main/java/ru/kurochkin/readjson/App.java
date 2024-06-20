package ru.kurochkin.readjson;

import ru.kurochkin.readjson.country.Country;
import ru.kurochkin.readjson.currency.Currency;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static final String COUNTRIES_FILE_NAME = "src/main/java/ru/kurochkin/readjson/input/countries.json";
    private static final String LESS_MILLION_POPULATION_COUNTRIES_FILE_NAME = "src/main/java/ru/kurochkin/readjson/output/resultCountries.json";
    private static final int POPULATION_LIMIT = 1000000;

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Country> countries;
            countries = objectMapper.readValue(new File(COUNTRIES_FILE_NAME), new TypeReference<>() {});
            long populationSum = countries.stream()
                    .filter(country -> country.getPopulation() != null)
                    .mapToLong(Country::getPopulation)
                    .sum();
            System.out.println("Сумма численности по странам: " + populationSum);

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

            List<Country> lessMillionPopulationCountriesList = countries.stream()
                    .filter(country -> country.getPopulation() != null && country.getPopulation() > POPULATION_LIMIT)
                    .toList();

            try {
                File lessMillionPopulationCountriesFile = new File(LESS_MILLION_POPULATION_COUNTRIES_FILE_NAME);

                if (!lessMillionPopulationCountriesFile.getParentFile().exists()) {
                    lessMillionPopulationCountriesFile.getParentFile().mkdir();
                }

                objectMapper.writeValue(lessMillionPopulationCountriesFile, lessMillionPopulationCountriesList);
                System.out.println("Страны, где численность не менее 1 млн, сохранены в файл: "
                        + "\"" + LESS_MILLION_POPULATION_COUNTRIES_FILE_NAME + "\"");
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла \""
                        + LESS_MILLION_POPULATION_COUNTRIES_FILE_NAME + "\": "
                        + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл \""
                    + COUNTRIES_FILE_NAME
                    + "\" не найден");
        } catch (UnrecognizedPropertyException e) {
            System.out.println("При чтении файла \""
                    + COUNTRIES_FILE_NAME + "\": "
                    + " обнаружено не известное поле "
                    + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла \""
                    + COUNTRIES_FILE_NAME + "\": "
                    + e.getMessage());
        }
    }
}