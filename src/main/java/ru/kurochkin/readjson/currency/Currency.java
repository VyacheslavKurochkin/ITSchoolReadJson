package ru.kurochkin.readjson.currency;

@SuppressWarnings("unused")
public class Currency {
    private String code;
    private String name;
    private String symbol;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Currency inputCurrency = (Currency) obj;

        return code.equals(inputCurrency.code);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = hash * prime + (code != null ? code.hashCode() : 0);
        return hash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
