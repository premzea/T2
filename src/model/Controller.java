package model;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Community> coms;

    public ArrayList<Place> places;

    /**
     * Method is the Constructor and initializes coms and places
     */

    public Controller() {
        this.coms = new ArrayList<>();
        this.places = new ArrayList<>();
    }

    // /**
    // * Method return the coms Array
    // *@return coms, type ArrayList<Community>
    // */

    // public ArrayList<Community> getComs() {
    // return coms;
    // }

    /**
     * Method creates and array with all the places names
     * 
     * @return array, type ArrayList<String>
     */

    public ArrayList<String> placesToString() {
        ArrayList<String> array = new ArrayList<>();
        if (!(places.isEmpty())) {
            for (int i = 0; i < places.size(); i++) {
                array.add(places.get(i).getName());
            }
        }
        return array;
    }

    /**
     * Method creates and array with all the communities names
     * 
     * @return array, type ArrayList<String>
     */

    public ArrayList<String> comsToString() {
        ArrayList<String> array = new ArrayList<>();
        if (!(coms.isEmpty())) {
            for (int i = 0; i < coms.size(); i++) {
                array.add(coms.get(i).getName());
            }
        }
        return array;
    }

    // public void setComs(ArrayList<Community> coms) {
    // this.coms = coms;
    // }

    // public ArrayList<Place> getPlaces() {
    // return places;
    // }

    // public void setPlaces(ArrayList<Place> places) {
    // this.places = places;
    // }

    /**
     * Method creates and adds a Community to the coms array
     */

    public void addCommunity(String pName, String pType, int pPopulation, String nameRep, String cellphone,
            String problem) {
        Community community = new Community(pName, pType, pPopulation, nameRep, cellphone, problem);
        coms.add(community);
    }

    /**
     * Method creates and adds a Place to the places array
     */

    public void addPlace(String pName, String pType, double pArea, int day, int month, int year, int indexCommunity,
            String department) {
        Place place = new Place(pName, pType, pArea, day, month, year, coms.get(indexCommunity), department);
        places.add(place);
    }

    /**
     * Method creates and adds a Product to a community from the coms array
     */

    public void addProduct(String placeNom, String pName, double perNatural, String pType, boolean pHandmade) {
        ////
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName() == placeNom) {
                coms.get(i).addProduct(pName, perNatural, pType, pHandmade);
                i = coms.size() + 1;
            }
        }
    }

    /**
     * Method modifies a community's product
     */

    public void modifyProduct(String comNom,int index, double perNatural, String pType, String pHandmade) {
        int indicator = 0;
        if (pHandmade == null) {
            indicator = 1;
        }
        boolean handmade = pHandmade.equals("true") ? true : false;
        // is there a way to do it without enetering products?
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(comNom)) {
                coms.get(i).modifyProduct(indicator, index, perNatural, pType, handmade);
                i = 100;
            }
        }
    }

    

    /**
     * Method creates a community's Product Names array
     * 
     * @return procNames, type String[]
     */

    public String getProductsNames(String nomCom) {
        String str = "";
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName() == nomCom) {
                str = coms.get(i).getProductNames();
                // list product names
            }
        }
        return str;
    }

    /**
     * Method creates a places's Species Names array
     * 
     * @return specNames, type String[]
     */

    public String[] getSpeciesNames(String nomCom) {
        String[] specNames = new String[15];
        for (int i = 0; i < places.size(); i++) {
            if (coms.get(i).getName() == nomCom) {
                specNames = places.get(i).getSpeciesNames();
            }
        }
        return specNames;
    }

    public void deleteProduct(String placeNom, int index) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(placeNom)) {
                coms.get(i).deleteProduct(index);
                i = 100;
            }

        }
    }

    /**
     * Method evaluates if places is empty
     * 
     * @return value, type boolean
     */

    public boolean hasPlaces() {
        return places.isEmpty() ? false : true;
    }

    /**
     * Method evaluates if communities is empty
     * 
     * @return value, type boolean
     */

    public boolean hasCommunities() {
        return coms.isEmpty() ? false : true;
    }

    /**
     * Method evaluates if a place has species
     * 
     * @return value, type boolean
     */

    public boolean hasSpecies(String placeNom) {
        boolean value = false;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getName().equals(placeNom)) {
                value = places.get(i).hasSpecies();
                i = 123;
            }

        }
        return value;
    }

    /**
     * Method evaluates if a community has prodcuts
     * 
     * @return value, type boolean
     */

    public boolean hasProducts(String comNom) {
        boolean value = false;
        Product output = null;
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getName().equals(comNom)) {
                value = coms.get(i).hasProducts();
            }

        }
        return value;

    }

    /**
     * Method adds species to a place
     */

    public void addSpecies(String nomPlace, String name, String pType, int pNumber) {
        for (int i = 0; i < places.size(); i++) {
            if (nomPlace == places.get(i).getName()) {
                places.get(i).addSpecies(name, pType, pNumber);
            }
        }
    }

    /**
     * Method modifies a place's species
     */

    public void modifySpecies(String nomPlace, String name, String pType, int pNumber) {
        // cannot access
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getName().equals(nomPlace)) {
                places.get(i).modifySpecies(name, pType, pNumber);
            }
            i = places.size() + 1;
        }
        /////
    }

    /**
     * Method deletes a places species
     */

    public void deleteSpecies(String placeNom, int index) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getName().equals(placeNom)) {
                places.get(i).deleteSpecies(index);
                i = 100;
            }
            i = places.size() + 1;
        }
    }

    /**
     * Method evaluates if a place can have more species
     * 
     * @return value, type boolean
     */

    public boolean canAddSpecies(String nom) {
        boolean value = false;
        for (int i = 0; i < places.size(); i++) {
            if (nom == places.get(i).getName()) {
                places.get(i).canAddSpecies();
            }
        }

        return value;
    }

    /**
     * Method evaluates if a community can have more products
     * 
     * @return value, type boolean
     */

    public boolean canAddProducts(String nom) {
        boolean value = false;
        for (int i = 0; i < coms.size(); i++) {
            if (nom == coms.get(i).getName()) {
                value = coms.get(i).canAddProducts();
            }
        }

        return value;
    }

    /**
     * Method modifies a community from coms
     */

    public void modifyCommunity(String pName, String pType, int pPopulation, String nameRep, String cellphone,
            String problem) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).equals(pName)) {
                Community originalCom = coms.get(i);
                if (pType == null) {
                    pType = originalCom.getType().name();
                }
                if (pPopulation == -1) {
                    pPopulation = originalCom.getPopulation();
                }
                if (nameRep == null) {
                    nameRep = originalCom.getRepresentative().getName();
                }
                if (cellphone == null) {
                    cellphone = originalCom.getRepresentative().getCellphone();
                }
                if (problem == null) {
                    problem = originalCom.getProblem();
                }
                Community com = new Community(pName, pType, pPopulation, nameRep, cellphone, problem);
                coms.remove(i);
                coms.add(i, com);
                i = coms.size() + 1;
            }
        }
    }

    /**
     * Method modifies a place from places
     */

    public void modifyPlace(String pName, String pType, double pArea, int day, int month, int year, int indexCom,
            String department) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).equals(pName)) {
                Place originalPlace = places.get(i);
                if (pType == null) {
                    pType = originalPlace.getType().name();
                }
                if (pArea == -1) {
                    pArea = originalPlace.getArea();
                }
                if (day == -1) {
                    day = originalPlace.getDate().getDay();
                }
                if (month == -1) {
                    month = originalPlace.getDate().getMonth();
                }
                if (year == -1) {
                    year = originalPlace.getDate().getYear();
                }

                if (indexCom == -1) {
                    String nameCom = originalPlace.getCommunityName();
                    for (i = 0; i < coms.size(); i++) {
                        if (nameCom.equals(coms.get(i).getName())) {
                            indexCom = i;
                            i = coms.size() + 1;
                        }
                    }
                }

                Community com = coms.get(indexCom);
                if (department == null) {
                    department = originalPlace.getDepartment();
                }
                Place place = new Place(pName, pType, pArea, day, month, year, com, department);
                places.remove(i);
                places.add(i, place);
                i = places.size() + 1;
            }
        }
    }

    /**
     * Method checks if a new community's name is original by comparing it to the
     * names of communities in coms
     * 
     * @return value, type boolean
     */

    public boolean comOriginal(String nom) {
        boolean validity = true;
        ArrayList<String> comsNames = comsToString();
        for (int i = 0; i < comsNames.size(); i++) {
            if (comsNames.get(i).equals(nom)) {
                i = comsNames.size() + 1;
                validity = false;
            }
        }
        return validity;

    }

    /**
     * Method checks if a new place's name is original by comparing it to the names
     * of places in places
     * 
     * @return value, type boolean
     */

    public boolean placeOriginal(String nom) {
        ArrayList<String> placesNames = placesToString();
        boolean validity = true;
        for (int i = 0; i < placesNames.size(); i++) {
            if (placesNames.get(i).equals(nom)) {
                i = placesNames.size() + 1;
                validity = false;
            }
        }
        return validity;
    }

    /**
     * Method deletes a community from coms
     */

    public void deleteCommunity(String nomCom) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).equals(nomCom)) {
                coms.remove(i);
                i = coms.size() + 1;
            }
        }
    }

    /**
     * Method deletes a place from places
     */

    public void deletePlace(String nomPlace) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).equals(nomPlace)) {
                places.remove(i);
                i = places.size() + 1;
            }
        }

    }

    /**
     * Method gets the names of the places of places and arranges it into a numbered
     * string
     * 
     * @return str, type string
     */

    public String getNamePlaces() {
        ArrayList<String> placesNames = placesToString();
        String str = "";
        for (int i = 0; i < placesNames.size(); i++) {
            str = str + "(" + (i + 1) + ") " + placesNames.get(i) + "\n";
        }

        return str;
    }

    /**
     * Method gets the names of the communities of coms and arranges it into a
     * numbered string
     * 
     * @return str, type string
     */

    public String getNamesComs() {
        ArrayList<String> comsNames = comsToString();
        String str = "";
        for (int i = 0; i < comsNames.size(); i++) {
            str = str + "(" + (i + 1) + ") " + comsNames.get(i) + "\n";
        }

        return str;
    }

    /**
     * Method gets the names of the communities that live in a same department
     * 
     * @return str, type string
     */

    public String departmentComs(String dep) {
        ArrayList<String> comNames = new ArrayList<>();
        String str = "\nCommunities in  " + dep + "\n";
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getDepartment().equals(dep)) {
                if (!(comNames.contains(places.get(i).getComInfo()))) {
                    comNames.add(places.get(i).getComInfo());
                    str = str + "\nCommunity " + (comNames.size()) + "\n" + places.get(i).getComInfo();
                }
            }

        }
        return str;

    }

    /**
    * Method gets the information of communities with a same problematic 
    *@return str, type string
    */

    public String comsbyProblem(String problematic){
        String str = "\nCommunities\n";
        for(int i = 0; i< coms.size(); i++){
            if(coms.get(i).getProblem().equals(problematic)){
                str = str + "Community " + (i+1) + "\n" +  coms.get(i).toString() + "\n"; 
            }
        }
        return str;
    }}
