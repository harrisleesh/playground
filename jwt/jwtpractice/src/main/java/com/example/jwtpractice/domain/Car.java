package com.example.jwtpractice.domain;

public class Car {
    private String carName;
    private String carType;

    public Car(String carName, String carType) {
        this.carName = carName;
        this.carType = carType;
    }

    private String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public Car(Builder builder) {
        this.carName = builder.getCarName();
        this.carType = builder.getCarType();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String carName;
        private String carType;

        public Car build(){
            return new Car(this);
        }

        public Builder() {
        }

        public Builder carName(String carName){
            this.carName = carName;
            return this;
        }

        public Builder carType(String carType) {
            this.carType = carType;
            return this;
        }

        public String getCarName() {
            return carName;
        }

        public String getCarType() {
            return carType;
        }
    }
}
