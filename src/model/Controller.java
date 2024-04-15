package model;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Communities> coms = new ArrayList<>();

    public ArrayList<Place> places = new ArrayList<>();

    public ArrayList<Communities> getComs() {
        return coms;
    }

    public ArrayList<String> placesToString() {
        ArrayList<String> array = new ArrayList<>();
        if (!(places.isEmpty())) {
            for (int i = 0; i < places.size(); i++) {
                array.add(places.get(i).getName());
            }
        }
        return array;
    }

    public ArrayList<String> comsToString() {
        ArrayList<String> array = new ArrayList<>();
        if (!(coms.isEmpty())) {
            for (int i = 0; i < coms.size(); i++) {
                array.add(coms.get(i).getName());
            }
        }
        return array;
    }

    public void setComs(ArrayList<Communities> coms) {
        this.coms = coms;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public void addCommunity(String pName, String pType, int pPopulation, String nameRep, String cellphone) {
        Communities community = new Communities(pName, pType, pPopulation, nameRep, cellphone);
        coms.add(community);
    }

    public void addPlace(String pName, String pType, double pArea, int day, int month, int year, String pCommunity) {
        Place place = new Place(pName, pType, pArea, day, month, year, pCommunity);
        places.add(place);
    }

    public void addProduct(String placeNom, String pName, double perNatural, String pType, boolean pHandmade) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName() == placeNom) {
                coms.get(i).addProduct(pName, perNatural, pType, pHandmade);
                i = coms.size() + 1;
            }
        }
    }

    public void modifyProduct(String comNom, String pName, double perNatural, String pType, String pHandmade) {
        //if decided no to change, changes it to none and thats wrong baby girl
        int indicator = 0;
        if(pHandmade == null){
            indicator = 1;
        }
        boolean handmade = pHandmade.equals("true") ? true : false;
        //is there a way to do it without enetering products?
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(comNom)) {
                for (int z = 0; z < 20; z++) {
                    if (coms.get(i).getProductNames()[z].equals(pName)) {
                        Products originalProduct = coms.get(i).getProducts()[z];
                        if(perNatural == -1){
                            perNatural = originalProduct.getperNatural();
                        }
                        if(pType == null){
                            pType = originalProduct.getType().name();
                        } 
                        if(indicator == 1){
                            handmade = originalProduct.getHandmade();
                        }
                        //more efficient way to do this?
                        Products product = new Products(pName, perNatural, pType, handmade);
                        coms.get(i).modifyProduct(z,pName, perNatural, pType, handmade);
                        z = 21;
                    }
                    i = 100;
                }
            }
        }
    }

    public String[] getProductsNames(String nomCom) {
        String[] procNames = new String[20];
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName() == nomCom) {
                procNames = coms.get(i).getProductNames();
                // list product names
            }
        }
        return procNames;
    }

    public String[] getSpeciesNames(String nomCom) {
        String[] specNames = new String[15];
        for (int i = 0; i < places.size(); i++) {
            if (coms.get(i).getName() == nomCom) {
                specNames = places.get(i).getSpeciesNames();
            }
        }
        return specNames;
    }

    public boolean hasProducts(String placeNom) {
        boolean value;
        Products output = null;
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(placeNom)) {
                output = coms.get(i).getProducts()[0];
                i = 123;
            }

        }
        value = output == null ? false : true;
        return value;

    }

    public void deleteProduct(String placeNom, int index) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(placeNom)) {
                coms.get(i).deleteProduct(index);
                i = 100;
            }

        }
    }

    public void addSpecies(String nomPlace, String name, String pType, int pNumber){
        for(int i = 0; i<places.size(); i++){
            if(nomPlace == places.get(i).getName()){
                places.get(i).addSpecies(name, pType, pNumber);
            }
        }
    }

    public boolean hasSpecies(String placeNom){
        boolean value;
        Products output = null;
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(placeNom)) {
                output = coms.get(i).getProducts()[0];
                i = 123;
            }

        }
        value = output == null ? false : true;
        return value;
    }

    public void modifySpecies(String nomPlace, String name, String pType, int pNumber){
        //cannot access 
        for (int i = 0; i < places.size(); i++) {
            if (coms.get(i).getName().equals(nomPlace)) {
                for (int z = 0; z < 15; z++) {
                    if (places.get(i).getSpeciesNames()[z].equals(name)) {
                        if(pType == null){
                            pType = places.get(i).getSpecies()[z].getType().name();
                        }
                        if(pNumber == -1){
                            pNumber = places.get(i).getSpecies()[z].getNumber();
                        }
                        places.get(i).modifySpecies(z, name, pType, pNumber);
                        z = 15;
                    }
                    i = 100;
                }
            }
        }
    }

    public void deleteSpecies(String placeNom, int index) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getName().equals(placeNom)) {
                places.get(i).deleteSpecies(index);
                i = 100;
                // should i somehow delete the product and move the whole index or just leave
                // the null?
            }

        }
    }

    public boolean canAddSpecies(String nom){
        boolean value = false;
        for(int i = 0; i<places.size(); i++){
            if(nom == places.get(i).getName()){
                if(places.get(i).getSpecies()[14] == null){
                    value = true;
                }
            }}

        return value;
    }

    public boolean canAddProducts(String nom){
        boolean value = false;
        for(int i = 0; i<coms.size(); i++){
            if(nom == coms.get(i).getName()){
                if(coms.get(i).getProducts()[19] == null){
                    value = true;
                }
            }}

        return value;
    }

    public void modifyCommunity(String pName, String pType, int pPopulation, String nameRep, String cellphone){
        for(int i = 0; i< coms.size(); i++){
            if(coms.get(i).equals(pName)){
                Communities originalCom = coms.get(i);
                if(pType==null){
                    pType = originalCom.getType().name();
                }
                if(pPopulation == -1){
                    pPopulation = originalCom.getPopulation();
                }
                if(nameRep == null){
                    nameRep = originalCom.getRepresentative().getName();
                }
                if(cellphone == null){
                    cellphone = originalCom.getRepresentative().getCellphone();
                }
                Communities com = new Communities(pName, pType, pPopulation, nameRep, cellphone);
                coms.remove(i); 
                coms.add(i, com);
                i = coms.size() +1;
            }
        }
    }

    public void modifyPlace(String pName, String pType, double pArea, int day, int month, int year, String pCommunity){
        for(int i = 0; i< places.size(); i++){
            if(places.get(i).equals(pName)){
                Place originalPlace = places.get(i);
                if(pType == null){
                    pType = originalPlace.getType().name();
                }
                if(pArea == -1){
                    pArea = originalPlace.getArea();
                }
                if(day == -1){
                    day = originalPlace.getDate().getDay();
                }
                if(month == -1){
                    month = originalPlace.getDate().getMonth();
                }
                if(year == -1){
                    year = originalPlace.getDate().getYear();
                }
                Place place = new Place(pName, pType, pArea, day, month, year, pCommunity);
                places.remove(i); 
                places.add(i, place);
                i = places.size() + 1;
            }
        }
    }

    public void deleteCommunity(String nomCom){
        for(int i = 0; i< coms.size(); i++){
            if(coms.get(i).equals(nomCom)){
                coms.remove(i);
                i = coms.size() + 1;
            }}
    }

    public void deletePlace(String nomPlace){
        for(int i = 0; i< places.size(); i++){
            if(places.get(i).equals(nomPlace)){
                places.remove(i);
                i = places.size() + 1;
            }}
        
    }
}
