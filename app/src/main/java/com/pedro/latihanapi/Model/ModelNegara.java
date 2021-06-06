package com.pedro.latihanapi.Model;

import java.util.List;

public class ModelNegara {


    private List<Negara> Countries;

    public List<Negara> getCountries() {
        return Countries;
    }

    public void setCountries(List<Negara> countries) {
        Countries = countries;
    }

    public class Negara{

        private String Country;
        private int TotalConfirmed;
        private int TotalDeaths;
        private int TotalRecovered;

        public String getCountry() {
            return Country;
        }

        public void setCountry(String country) {
            Country = country;
        }

        public int getTotalConfirmed() {
            return TotalConfirmed;
        }

        public void setTotalConfirmed(int totalConfirmed) {
            TotalConfirmed = totalConfirmed;
        }

        public int getTotalDeaths() {
            return TotalDeaths;
        }

        public void setTotalDeaths(int totalDeaths) {
            TotalDeaths = totalDeaths;
        }

        public int getTotalRecovered() {
            return TotalRecovered;
        }

        @Override
        public String toString() {
            return "Negara{" +
                    "Country='" + Country + '\'' +
                    ", TotalConfirmed=" + TotalConfirmed +
                    ", TotalDeaths=" + TotalDeaths +
                    ", TotalRecovered=" + TotalRecovered +
                    '}';
        }

        public void setTotalRecovered(int totalRecovered) {
            TotalRecovered = totalRecovered;



        }
    }


    }



