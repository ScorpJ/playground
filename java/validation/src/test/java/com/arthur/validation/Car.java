package com.arthur.validation;



@BusinessRules(rules = {
  @BusinessRule(validateType = ValidateType.EXPRESS_PREDICATE, onCondition = "true", predicate = "manufacturer != null and licensePlate != null", message="manufacturer and/or licensePlate is null."),
  @BusinessRule(validateType = ValidateType.EXPRESS_PREDICATE, onCondition = "seatCount > 0", predicate = "seatCount > 1", message = "seatCount is less than 1")
})
public class Car {

    private String manufacturer;
    private String licensePlate;
    private int seatCount;

    public Car(String manufacturer, String licensePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
