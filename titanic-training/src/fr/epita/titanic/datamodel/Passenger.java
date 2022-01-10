package fr.epita.titanic.datamodel;

public class Passenger {
    private Integer passengerId;
    private Integer pClass;
    private String name;
    private String sex;
    private Double age;
    private Integer numberOfSibSp;
    private Integer numberOfParCh;
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarkedPort;
    private Boolean survived;

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getpClass() {
        return pClass;
    }

    public void setpClass(Integer pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Integer getNumberOfSibSp() {
        return numberOfSibSp;
    }

    public void setNumberOfSibSp(Integer numberOfSibSp) {
        this.numberOfSibSp = numberOfSibSp;
    }

    public Integer getNumberOfParCh() {
        return numberOfParCh;
    }

    public void setNumberOfParCh(Integer numberOfParCh) {
        this.numberOfParCh = numberOfParCh;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarkedPort() {
        return embarkedPort;
    }

    public void setEmbarkedPort(String embarkedPort) {
        this.embarkedPort = embarkedPort;
    }

    public Boolean getSurvived() {
        return survived;
    }

    public void setSurvived(Boolean survived) {
        this.survived = survived;
    }
}
