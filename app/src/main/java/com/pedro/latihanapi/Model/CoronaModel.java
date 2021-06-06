package com.pedro.latihanapi.Model;

import java.util.List;

public class CoronaModel {

    private int Result;
    private List<Result> list_data;

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public List<CoronaModel.Result> getList_data() {
        return list_data;
    }

    public void setList_data(List<CoronaModel.Result> list_data) {
        this.list_data = list_data;
    }

    public class Result{

        private String key;
        private int jumlah_kasus;
        private int jumlah_sembuh;
        private int jumlah_meninggal;
        private int jumlah_dirawat;
        private double doc_count;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getJumlah_kasus() {
            return jumlah_kasus;
        }

        public void setJumlah_kasus(int jumlah_kasus) {
            this.jumlah_kasus = jumlah_kasus;
        }

        public int getJumlah_sembuh() {
            return jumlah_sembuh;
        }

        public void setJumlah_sembuh(int jumlah_sembuh) {
            this.jumlah_sembuh = jumlah_sembuh;
        }

        public int getJumlah_meninggal() {
            return jumlah_meninggal;
        }

        public void setJumlah_meninggal(int jumlah_meninggal) {
            this.jumlah_meninggal = jumlah_meninggal;
        }

        public int getJumlah_dirawat() {
            return jumlah_dirawat;
        }

        public void setJumlah_dirawat(int jumlah_dirawat) {
            this.jumlah_dirawat = jumlah_dirawat;
        }

        public double getDoc_count() {
            return doc_count;
        }

        public void setDoc_count(int doc_count) {
            this.doc_count = doc_count;
        }


        @Override
        public String toString() {
            return "Result{" +
                    "key='" + key + '\'' +
                    ", jumlah_kasus=" + jumlah_kasus +
                    ", jumlah_sembuh=" + jumlah_sembuh +
                    ", jumlah_meninggal=" + jumlah_meninggal +
                    ", jumlah_dirawat=" + jumlah_dirawat +
                    ", doc_count=" + doc_count +
                    '}';
        }
    }

}
