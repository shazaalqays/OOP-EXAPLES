/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.*;

/**
 *
 * @author YOGA
 */
public class PersonOperations {

    private static int count = 1;
    List<Person> personList = new ArrayList<>();
    List<Integer> ids_shaza = new ArrayList<>();
    List<String> usernames = new ArrayList<>();
    
    public List<Integer> getIds_shaza() {
        return ids_shaza;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public Person add(Person p) { //1.add methodu
        if (personList.isEmpty()) {
            p.setId(count);
            personList.add(p);
            usernames.add(p.getUsername());
            return p;
        } else {
            // personList içerisindeki personları for ile gez
            // id listesine personel id'lerini ekle
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < personList.size(); i++) {
                ids.add(personList.get(i).getId());
            }
            // max id'yi bul
            Integer max = Collections.max(ids);
            // +1 ekle
            p.setId(max + 1);
            personList.add(p);
            usernames.add(p.getUsername());
            return p;
        }
    }
    
    public Person addShaza(Person p){
        if (personList.isEmpty()){
            p.setId(count);
            personList.add(p);
            ids_shaza.add(p.getId());
            usernames.add(p.getUsername());
            return p;
        }
        else if(personList.contains(p)){
            System.out.println("This person is in the list");
            return p;
        }
        else{
            for (int i = 0; i< personList.size();i++){
                ids_shaza.add(personList.get(i).getId());
            }
            Integer Max = Collections.max(ids_shaza);
            p.setId(Max+1);
            personList.add(p);
            usernames.add(p.getUsername());
            return p;
        }
    }
    
    public void updateHeight(Person p, int h){
        p.setHeight(h);
    }
    
    public void updateWeight(Person p, int w){
        p.setWeight(w);
    }
    
    public void updateUsername(Person p, String u){
        p.setUsername(u);
    }
    
    public void updatePassword(Person p, String pass){
        p.setPassword(pass);
    }
    
    public void updateSurname(Person p, String s){
        p.setSurname(s);
    }
    
    public void Delete(int id){
        List ids = getIds_shaza();
        if(ids.isEmpty()){
            System.out.println("No people\n");
        }
        else if(ids.contains(id)){
            for(Person p: personList){
                if(p.getId() == id){
                    personList.remove(p);
                    break;
                }
            }
        }
        else{
            System.out.println("There's no such a person\n");
        }
    }
    
    public void view(Person p){
        p.toString();
    }
    
    public void list(){
        if(personList.isEmpty()){
            System.out.println("No people");
        }
        else{
            for(Person p: personList){
                System.out.println(p.toString());
            }
        }
    }
    
    public void search(String name){
        for (Person p: personList){
            if(p.getName().equals(name)){
                System.out.println("Found");
                break;
            }
        }
    }
    
    
    public void viewInfo(Person p){
        System.out.println(p.toString());
    }
    /*
    1- add ( 2 .versiyonu ) -> bu personel zaten listede var mı ?
   2-  person güncelleme 
    mainde soracaksın ? neyi güncellemek istersiniz ? 
    - boy
    - kilo
    - username
    - password
    - surname
    
    bunlar güncellenebilir olacak
    
    3- person silme
    4- kendi bilgilerini görüntüleyebilme
    5- bütün personları listeleyebilme
    6- iisme göre arama vs
    
     */
    private boolean isExist(Person p) {

        if (personList.contains(p)) {
            return true;
        } else {
            return false;
        }

    }

}
