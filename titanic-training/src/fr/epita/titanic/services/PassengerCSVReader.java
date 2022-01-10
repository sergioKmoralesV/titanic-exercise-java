package fr.epita.titanic.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.epita.titanic.datamodel.Passenger;

public class PassengerCSVReader {
     public List<Passenger> read(File file){
          List<Passenger> passengers = new ArrayList<>();
          try {
               List<String> lines = Files.readAllLines(file.toPath());
               Integer i = 0;
               for (String line: lines){
                    if(i!=0) {
                         line = line.replaceAll(",",";");
                         line =   line.replaceAll("; ", ", ");
                         String[] split = line.split(";");

                         Passenger instance = new Passenger();

                         instance.setPassengerId(Integer.parseInt(split[0]));
                         instance.setpClass(Integer.parseInt(split[1]));
                         instance.setName(split[2]);
                         instance.setSex(split[3]);
                         if(!split[4].isEmpty()) {
                              instance.setAge(Double.parseDouble(split[4]));
                         }

                         instance.setNumberOfSibSp(Integer.parseInt(split[5]));
                         instance.setNumberOfParCh(Integer.parseInt(split[6]));
                         instance.setTicket(split[7]);
                         if(!split[8].isEmpty()) {
                              instance.setFare(Double.parseDouble(split[8]));
                         }

                         if(!split[9].isEmpty()){
                              instance.setCabin(split[9]);
                         }
                         instance.setEmbarkedPort(split[10]);

                         passengers.add(instance);
                    }

                    i++;
               }
          } catch (IOException e) {
               e.printStackTrace();
          }

          return passengers;
     }

     public List<Passenger> readTrain(File file){
          List<Passenger> passengers = new ArrayList<>();
          try {
               List<String> lines = Files.readAllLines(file.toPath());
               Integer i = 0;
               for (String line: lines){
                    if(i!=0) {
                         line = line.replaceAll(",",";");
                         line =   line.replaceAll("; ", ", ");
                         String[] split = line.split(";");

                         Passenger instance = new Passenger();

                         instance.setPassengerId(Integer.parseInt(split[0]));
                         if(split[1].equals("0")) {
                              instance.setSurvived(false);
                         } else {
                              instance.setSurvived(true);
                         }

                         instance.setpClass(Integer.parseInt(split[2]));
                         instance.setName(split[3]);
                         instance.setSex(split[4]);
                         if(!split[5].isEmpty()) {
                              instance.setAge(Double.parseDouble(split[5]));
                         }

                         instance.setNumberOfSibSp(Integer.parseInt(split[6]));
                         instance.setNumberOfParCh(Integer.parseInt(split[7]));
                         instance.setTicket(split[8]);
                         if(!split[9].isEmpty()) {
                              instance.setFare(Double.parseDouble(split[9]));
                         }

                         if(!split[10].isEmpty()){
                              instance.setCabin(split[10]);
                         }

                         if(split.length > 11) {
                              instance.setEmbarkedPort(split[11]);
                         }
                         passengers.add(instance);
                    }

                    i++;
               }
          } catch (IOException e) {
               e.printStackTrace();
          }

          return passengers;
     }

}
