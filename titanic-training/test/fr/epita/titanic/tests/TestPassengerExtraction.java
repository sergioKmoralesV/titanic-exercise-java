package fr.epita.titanic.tests;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.epita.titanic.datamodel.Passenger;
import fr.epita.titanic.services.PassengerCSVReader;

public class TestPassengerExtraction {
    public static Double calculateAverageAge(List<Passenger> listOfPassengers) {
        Double totalAge = 0.0;
        Double totalCount = 0.0;
        for(Passenger passenger: listOfPassengers) {
            if(passenger.getAge() != null) {
                totalAge += passenger.getAge();
                totalCount += 1;
            }
        }
        return totalAge/totalCount;
    }

    public static Double calculateAverageAgeBySex(List<Passenger> listOfPassengers, String filterSex) {
        Double totalAge = 0.0;
        Double totalCount = 0.0;
        for(Passenger passenger: listOfPassengers) {
            if(passenger.getAge() != null && filterSex.equals(passenger.getSex())) {
                totalAge += passenger.getAge();
                totalCount += 1;
            }
        }
        return totalAge/totalCount;
    }

    public static int countSex(List<Passenger> passengers, String filterSex) {
        int totalCount = 0;
        for(Passenger passenger: passengers) {
            if(filterSex.equals(passenger.getSex())) {
                totalCount += 1;
            }
        }
        return totalCount;
    }

    public static Double standardDeviationOfAge(List<Passenger> passengers) {
        Double mean = calculateAverageAge(passengers);
        Double sum = 0.0;
        Double totalCount = 0.0;
        for(Passenger pas:passengers){
            if(pas.getAge() != null) {
                sum += Math.pow(pas.getAge() - mean, 2);
                totalCount += 1;
            }
        }
        return Math.pow(sum/totalCount, 0.5);
    }

    public static Integer countAccordingStatus(List<Passenger> passengers, Boolean isSurvival) {
        Integer total = 0;
        for(Passenger pas:passengers){
            if(pas.getSurvived() != null) {
                if(pas.getSurvived() == isSurvival) {
                    total+=1;
                }
            }
        }
        return total;
    }

    public static Integer countEmbarked(List<Passenger> passengers) {
        Integer total = 0;
        for(Passenger pas:passengers){
            if(pas.getEmbarkedPort() != null) {
                total+=1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        PassengerCSVReader reader = new PassengerCSVReader();
        List<Passenger> passengers = reader.read(new File("/Users/sergiomoralesvillarroel/personal/academic/EPITA/classes/java & uml/2021-t3-java-uml-ais/titanic-training/test.csv"));

        System.out.println("Statistics for test.csv");
        System.out.println("Overall average age: " + calculateAverageAge(passengers));
        System.out.println("From "+passengers.size()+" passengers, "+countSex(passengers,"male")+" are male and "+countSex(passengers,"female")+" are female.");
        System.out.println("Overall average age for males: " + calculateAverageAgeBySex(passengers, "male"));
        System.out.println("Overall average age for females: " + calculateAverageAgeBySex(passengers, "female"));
        System.out.println("Age standard deviation: "+standardDeviationOfAge(passengers));

        List<Passenger> passengers_train = reader.readTrain(new File("/Users/sergiomoralesvillarroel/personal/academic/EPITA/classes/java & uml/2021-t3-java-uml-ais/titanic-training/train.csv"));
        System.out.println("\nStatistics for train.csv");
        System.out.println("Overall average age: " + calculateAverageAge(passengers_train));
        System.out.println("From "+passengers_train.size()+" passengers, "+countSex(passengers_train,"male")+" are male and "+countSex(passengers_train,"female")+" are female.");
        System.out.println("Overall average age for males: " + calculateAverageAgeBySex(passengers_train, "male"));
        System.out.println("Overall average age for females: " + calculateAverageAgeBySex(passengers_train, "female"));
        System.out.println("Age standard deviation: "+standardDeviationOfAge(passengers_train));

        int survivals = countAccordingStatus(passengers_train, true);
        int deaths = countAccordingStatus(passengers_train, false);
        System.out.println("From "+passengers_train.size()+" passengers, "
                +survivals+" survived and "
                +deaths+" didn't survive.");
        System.out.println("From "+passengers_train.size()+" passengers, only "
                +countEmbarked(passengers_train)+" embarked.");

    }
}
