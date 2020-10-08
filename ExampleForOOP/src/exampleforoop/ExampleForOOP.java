/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleforoop;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
import operations.*;

/**
 *
 * @author YOGA
 */
public class ExampleForOOP {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        USERNAME VE PASSWORD GİRİn
        1- eğer ki admin & admin ise ekleme,silme,listeleme ve arama'dan hangisini yapmak istediği sorulacak
        2- personList'teki herhangi bir personelin username & password ise kendi bilgilerini görme, güncelleme işlemlerinden hangisini istediği sorulacak
        3- personList'te böyle bir kişi yok ise 'Kayıtlı olmayan kullanıcı.' uyarısı yapılacak ve bir işlem olmayacak
        */
        
        String username;
        String password;
        String choice;
        int i = 0;
        int m = 0;
        int us = 0;
        int he = 0;
        int we = 0;
        Person p = new Person();
        Person admin = new Person("ADMIN", "ADMIN", ADMIN_USERNAME, ADMIN_PASSWORD, BloodType.ABPLUS, Gender.M, 180, 70);
        PersonOperations po = new PersonOperations();
        Scanner user = new Scanner(System.in);
        while(i == 0){
            System.out.println("Enter username: ");
            username = user.nextLine();
            System.out.println("Enter password: ");
            password = user.nextLine();
            if(username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)){
                System.out.println("YOU ENTERED AS AN ADMIN");
                m = 0;
                while(m == 0){
                    System.out.println("Press 1 to add a person: ");
                    System.out.println("Press 2 to remove a person: ");
                    System.out.println("Press 3 to list people: ");
                    System.out.println("Press 4 to search for a person: ");
                    System.out.println("Press 5 to exit: ");
                    choice = user.nextLine();
                    System.out.println();
                    switch (choice) {
                        case "1":
                            Person p2 = new Person();
                            System.out.println("Enter person's name: ");
                            String name = user.nextLine();
                            p2.setName(name);
                            System.out.println("Enter person's surname: ");
                            String surname = user.nextLine();
                            p2.setSurname(surname);
                            us = 0;
                            while(us == 0){
                                System.out.println("Enter person's username: ");
                                String username1 = user.nextLine();
                            
                                if(po.getUsernames().contains(username1)){
                                    System.out.println("This username is taken. Try a different username.\n");
                                }
                                else{
                                    p2.setUsername(username1);
                                    us = 1;
                                }
                            }
                            System.out.println("Enter person's password: ");
                            String password1 = user.nextLine();
                            p2.setPassword(password1);
                            System.out.println("Enter person's blood type (APLUS, BPLUS, ZEROPLUS, ABPLUS, AMIN, BMIN, ZEROMIN): ");
                            String blood = user.nextLine();
                            p2.setBloodType(BloodType.valueOf(blood));
                            System.out.println("Enter person's gender (M/W): ");
                            String gender = user.nextLine();
                            p2.setGender(Gender.valueOf(gender));
                            he = 0;
                            int n1;
                            while(he == 0){
                                    System.out.println("Enter person's height: ");
                                    
                                    try{
                                        String height = user.nextLine();
                                        n1 = Integer.parseInt(height);
                                        p2.setHeight(n1);
                                        he = 1;
                                    }
                                    catch(NumberFormatException e){
                                        System.out.println("Enter a number");
//                                        String height = user.nextLine();
                                    }
                            }
                            we  = 0;
                            int n2;
                            while(we == 0){
                                System.out.println("Enter person's weight: ");
                                try{
                                    String weight = user.nextLine();
                                    n2 = Integer.parseInt(weight);
                                    p2.setWeight(n2);
                                    we = 1;
                                }
                                catch(NumberFormatException e){
                                    System.out.println("Enter a number");
                                }
                            }
                            
                            po.addShaza(p2);
                            break;
                        case "2":
                            System.out.println("Enter the ID of the person you need to delete");
                            int id = user.nextInt();
                            po.Delete(id);
                            break;
                        case "3":
                            po.list();
                            break;
                        case "4":
                            System.out.println("Enter the name of the person you need to search for");
                            String name1 = user.nextLine();
                            po.search(name1);
                            break;
                        case "5":
                            m = 1;
                            break;
                        default:
                            System.out.println("You pressed a wrong number. Try again");
                    }   
                    
                }
            }
            else if(po.getUsernames().contains(username)){
                for(Person p1: po.getPersonList()){
                    if(p1.getPassword().equals(password)){
                        m = 0;
                        while(m == 0){
                            System.out.println("Press 1 to view information: ");
                            System.out.println("Press 2 to update: ");
                            System.out.println("Press 3 to exit: ");
                            choice = user.nextLine();
                            switch (choice) {
                                case "1":
                                    po.viewInfo(p1);
                                    break;
                                case "2":
                                    System.out.println("Press 1 to update surname: ");
                                    System.out.println("Press 2 to update username: ");
                                    System.out.println("Press 3 to update password: ");
                                    System.out.println("Press 4 to update height: ");
                                    System.out.println("Press 5 to update weight: ");
                                    String ch = user.nextLine();
                                    switch(ch){
                                        case "1":
                                            System.out.println("Enter new surname: ");
                                            String sn = user.nextLine();
                                            po.updateSurname(p1, sn);
                                            break;
                                        case "2":
                                            System.out.println("Enter new username: ");
                                            String un = user.nextLine();
                                            po.updateUsername(p1, un);
                                            break;
                                        case "3":
                                            System.out.println("Enter new password: ");
                                            String ps = user.nextLine();
                                            po.updatePassword(p1, ps);
                                            break;
                                        case "4":
                                            System.out.println("Enter new height: ");
                                            int h1 = user.nextInt();
                                            po.updateHeight(p1,h1);
                                            break;
                                        case "5":
                                            System.out.println("Enter new weight: ");
                                            int w1 = user.nextInt();
                                            po.updateWeight(p1, w1);
                                            break;
                                        default:
                                            System.out.println("You pressed a wrong number. Try again");
                                    }
                                    break;
                                case "3":
                                    m = 1;
                                    break;
                            }   
                    
                        }
                    }
                }
            }
            else{
                System.out.println("You pressed a wrong number. Try again");
                System.out.println("If you want to finish the porgram press 1 else press any key");
                String cho = user.nextLine();
                if(Integer.parseInt(cho) == 1 ){
                    i = 1;
                }
                else{
                    i = 0;
                }
                
            }
            
        }
        
    }
}
