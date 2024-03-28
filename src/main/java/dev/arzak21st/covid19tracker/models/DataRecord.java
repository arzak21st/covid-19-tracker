
package dev.arzak21st.covid19tracker.models;

public class DataRecord {

    /* ========== Properties ========== */
    private String provinceState;
    private String countryRegion;
    private String lastUpdate;
    private int confirmed;
    private int deaths;
    private int recovered;

    /* ========== Constructors ========== */
    public DataRecord() {

    }

    public DataRecord(String provinceState, String countryRegion, String lastUpdate, int confirmed, int deaths, int recovered) {

        this.provinceState = provinceState;
        this.countryRegion = countryRegion;
        this.lastUpdate = lastUpdate;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    /* ========== Getters/Setters ========== */
    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    /* ========== Overriden Methods ========== */
    @Override
    public String toString() {
        return "Covid19DataRecord{" + "provinceState=" + provinceState + ", countryRegion=" + countryRegion + ", lastUpdate=" + lastUpdate + ", confirmed=" + confirmed + ", deaths=" + deaths + ", recovered=" + recovered + '}';
    }
}
