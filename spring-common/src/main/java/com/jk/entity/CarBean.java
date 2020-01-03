package com.jk.entity;

public class CarBean {



    private Integer carId;
    private String carPingPai;
    private String carCheXi;
    private Integer carPrice;
    private String carColor;
    private String carPhoto;

    @Override
    public String toString() {

        return "CarBean{" +
                "carId=" + carId +
                ", carPingPai='" + carPingPai + '\'' +
                ", carCheXi='" + carCheXi + '\'' +
                ", carPrice=" + carPrice +
                ", carColor='" + carColor + '\'' +
                ", carPhoto='" + carPhoto + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }

    private String carName;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarPingPai() {
        return carPingPai;
    }

    public void setCarPingPai(String carPingPai) {
        this.carPingPai = carPingPai;
    }

    public String getCarCheXi() {
        return carCheXi;
    }

    public void setCarCheXi(String carCheXi) {
        this.carCheXi = carCheXi;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarPhoto() {
        return carPhoto;
    }

    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
