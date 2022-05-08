package com.example.furdoruha;

//Adatmodell definiálás(osztály)


public class FurdoRuha {


        private String name;
        private String info;
        private String price;

        public FurdoRuha( String name, String info, String price, float ratedInfo, int imageResource) {
            this.name = name;
            this.info = info;
            this.price = price;
        }

    public FurdoRuha(String name, String furdoruhaLeira, String price) {
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}

