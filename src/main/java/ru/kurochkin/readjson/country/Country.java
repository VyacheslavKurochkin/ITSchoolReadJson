package ru.kurochkin.readjson.country;

import java.util.ArrayList;

import ru.kurochkin.readjson.currency.Currency;
import ru.kurochkin.readjson.language.*;
import ru.kurochkin.readjson.regionalbloc.*;
import ru.kurochkin.readjson.translations.*;

@SuppressWarnings("unused")
public class Country {
    private String name;
    private ArrayList<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private ArrayList<String> callingCodes;
    private String capital;
    private ArrayList<String> altSpellings;
    private String region;
    private String subregion;
    private Integer population;
    private ArrayList<Double> latlng;
    private String demonym;
    private Double area;
    private Double gini;
    private ArrayList<String> timezones;
    private ArrayList<String> borders;
    private String nativeName;
    private String numericCode;
    private ArrayList<Currency> currencies;
    private ArrayList<Language> languages;
    private Translations translations;
    private String flag;
    private ArrayList<RegionalBloc> regionalBlocs;
    private String cioc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(ArrayList<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public ArrayList<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(ArrayList<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public ArrayList<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(ArrayList<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public ArrayList<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(ArrayList<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(ArrayList<String> timezones) {
        this.timezones = timezones;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public void setBorders(ArrayList<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public ArrayList<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(ArrayList<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }
}