package ui;

import model.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class COP16_DataSystem {

    public static Scanner sc = new Scanner(System.in);

    public static Controller controller = new Controller();

    // Todo Try and Consults Menu; And picture parameters maybe

    public static void main(String[] args) {
        int option = 3;
        do {
            option = showMenu();
            switch (option) {
                case 1:
                    administrativeMenu();
                    break;

                case 2:
                    consultsMenu();
                    break;
            }
        } while (option != 3);

    }

    public static int showMenu() {
        int entry = askUserInput(
                "\nEnter: \n1.To modify information in the COP16 database \n2.To consult information in the COP16 database \n3.Exit Application",
                3);
        return entry;
    }

    public static void administrativeMenu() {
        int entry = askUserInput(
                "\nEnter: \n1.To enter,modify or delete a community \n2.To enter,modify or delete a place \n3.To enter,modify or eliminate a product \n4.To enter,modify or delete a species ",
                4);
        switch (entry) {
            case 1:
                communityOperations();
                break;

            case 2:
                placeOperations();
                break;

            case 3:
                productOperations();
                break;
            case 4:
                speciesOperations();
        }

    }

    public static void consultsMenu() {
        //Consultar foto? Do we need to display it?
        int entry = askUserInput("\nEnter: \n1. Consult place's picture and attribute\n2. Consult information from a department's community \n3.Consult communities with a same problematic \n4.Consult place with most species \n5.Consult biggest places", 5);
        switch (entry) {
            case 1:
                consultPlace();
                break;
        
            case 2:
                consultPlaceCom();
                break;
            
            case 3:
                consultComsProblem();
                break;

            case 4:
                consultPlaceMostSpecies();
                break;
            
            case 5:
                consultBiggestPlaces();
                break;
        }
    }

    public static void consultPlace(){
        ArrayList<String> placesNames = controller.placesToString();
        if (placesNames.get(0) == null) {
            System.out.println("No places created. Unable to show unexisting places");
        } else {
            System.out.println("\nChoose place to consult: \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);
            String attributes = controller.places.get(entry-1).toString();
            System.out.println(attributes);
        }

    }

    public static void consultPlaceCom(){
        ArrayList<String> placesNames = controller.placesToString();
        if (placesNames.get(0) == null) {
            System.out.println("No places created. Unable to show unexisting places");
        } else {
            System.out.println("\nChoose place to consult it's community: \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);
            System.out.println("Community: " + controller.places.get(entry-1).getCommunity());
        }
    }

    public static void consultBiggestPlaces(){
        double size1 = 0;
        double size2 = 0;
        double size3 = 0;
        String[] names = new String[3];
        int index1 = 0;
        for(int i = 0; i<controller.places.size(); i++){
            if(controller.places.get(i).getArea() > size1){
                size1 = controller.places.get(i).getArea();
                index1 = i;
                names[0] = controller.places.get(i).getName();
            }
        }
        int index2 = 0;
        for(int i = 0; i<controller.places.size(); i++){
            if(controller.places.get(i).getArea() > size1 && i != index1){
                size2 = controller.places.get(i).getArea();
                index2 = i;
                names[1] = controller.places.get(i).getName();
            }
        }
        for(int i = 0; i<controller.places.size(); i++){
            if(controller.places.get(i).getArea() > size1 && i != index1 && i != index2){
                size3 = controller.places.get(i).getArea();
                names[2] = controller.places.get(i).getName();
            }
        }
        System.out.println("\nBiggest Places \n1." + names[0] + "  Area(km^2): " + size1 + "\n2." + names[1] + "  Area(km^2): " + size2 + "\n3." + names[2] + "Area(km^2): " + size3);
    }

    
    public static void communityOperations() {
        int entry = askUserInput(
                "\nCommunity Menu \n(1) Enter Community \n(2) Modify Community \n(3) Eliminate Community\n",
                3);
        switch (entry) {
            case 1:
                addCommunity();
                break;

            case 2:
                modifyCommunity();
                break;

            case 3:
                deleteCommunity();
                break;
        }
    }

    public static void placeOperations() {
        int entry = askUserInput("\nPlace Menu \n(1) Enter Place \n(2) Modify Place \n(3) Eliminate Place\n",
                3);
        switch (entry) {
            case 1:
                addPlace();
                break;

            case 2:
                modifyPlace();
                break;

            case 3:
                deletePlace();
                break;
        }
    }

    public static void productOperations(){
        int entry = askUserInput("\nProduct Menu \n(1) Enter Product \n(2) Modify Product \n(3) Eliminate Product\n",
                3);
        switch (entry) {
            case 1:
                addProduct();
                break;

            case 2:
                modifyProduct();
                break;

            case 3:
                deleteProduct();
                break;
        }
    }

    public static void addProduct(){
        ArrayList<String> placesNames = controller.comsToString();
        if (placesNames.get(0) == null) {
            System.out.println("No communities created. Unable to add product");
        } else {
            System.out.println("\nNew Product\nAdd to which community: \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);
            // String comName, String pName, double perNatural, String pType, boolean
            // pHandmade
            if (controller.canAddProducts(nom)) {
                System.out.println("Product name: ");
                String nomProduct = sc.nextLine();
                System.out.println("\nPercentaje of natural materials: ");
                double perNatural = sc.nextDouble();
                sc.nextLine();
                entry = askUserInput("\nType of product \n(1) Food \n(2) Craft", 2);
                String tipo = "";
                tipo = entry == 1 ? "ALIMENTICIO" : "ARTESANIA";
                entry = askUserInput("\nIs it handmade? \n(1) Yes \n(2) No", 2);
                boolean handmade = false;
                handmade = entry == 1 ? true : false;
                controller.addProduct(nom, nomProduct, perNatural, tipo, handmade);
                System.out.println("\nProduct added succesfully \n");

            } else {
                System.out.println("The product field is full. Can no longer add products\n");
            }

        }
    }

    public static void modifyProduct(){
        ArrayList<String> comsNames = controller.comsToString();
        System.out.println("\nModify Product\nFrom which community: \n");
        for (int i = 0; i < comsNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + comsNames.get(i) + "\n");
        }
        int entry = sc.nextInt();
        sc.nextLine();
        String nom = comsNames.get(entry - 1);
        boolean value = controller.hasProducts(nom);
        if (value) {
            String[] comsNameStrings = new String[20];
            comsNameStrings = controller.getProductsNames(nom);
            System.out.println("\nModify Product: \n");
            int z = 0;
            for (int i = 0; i < 20; i++) {
                if (comsNameStrings[i] != null) {
                    System.out.println("(" + (z + 1) + ") " + comsNameStrings[i] + "\n");
                    z = z + 1;
                }
            }
            entry = sc.nextInt();
            sc.nextLine();
            String productName = comsNameStrings[entry - 1];
            // show the values before asking if modifying
            entry = askUserInput("\nEnter: \n1.To modify the natural percentaje \n2.Do not modify", 2);
            double perNatural = -1;
            switch (entry) {
                case 1:
                    System.out.println("\nNew Value: ");
                    perNatural = sc.nextDouble();
                    sc.nextLine();

                    break;

                default:
                    break;
            }
            entry = askUserInput("\nEnter: \n1.To modify the type of product \n2.Do not modify ", 2);
            String type = null;
            switch (entry) {
                case 1:
                    System.out.println("\nNew Type: \n1.Food \n2.Craft");
                    int input = sc.nextInt();
                    type = input == 1 ? "ALIMENTICIO" : "ARTESANIA";
                    sc.nextLine();
                    break;

                default:
                    break;
            }
            entry = askUserInput("\nEnter: \n1.To modify if product is handmade \n2.Do not modify", 2);
            String pHandmade = null;
            switch (entry) {
                case 1:
                    int input = askUserInput("\nIs the product handmade? \n1.Yes \n2.No", 2);
                    pHandmade = entry == 1 ? "true" : "false";
                    break;

                default:
                    break;
            }

            controller.modifyProduct(nom, productName, perNatural, type, pHandmade);

            System.out.println("\nProduct modified succesfully");
        } else {
            System.out.println("\nThis community has no products \n");
        }

    }

    public static void deleteProduct(){
        ArrayList<String> comsNames = controller.comsToString();
        System.out.println("\nDelete Product\nFrom which community: \n");
        for (int i = 0; i < comsNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + comsNames.get(i) + "\n");
        }
        int entry = sc.nextInt();
        sc.nextLine();
        String nom = comsNames.get(entry - 1);
        boolean value = controller.hasProducts(nom);
        if (value) {
            String[] comsNameStrings = new String[20];
            comsNameStrings = controller.getProductsNames(nom);
            System.out.println("\nDelete Product: \n");
            for (int i = 0; i < 20; i++) {
                if (comsNameStrings[i] != null) {
                    System.out.println((i + 1) + ". " + comsNameStrings[i] + "\n");
                }

            }
            entry = sc.nextInt() - 1;
            sc.nextLine();
            controller.deleteProduct(nom, entry);
            System.out.println("Product Deleted Succesfully \n");

        } else {
            System.out.println("\nThis community has no products \n");
        }
    }

    public static void addPlace(){
        // do we make necesary the addition of a picture
        // String pName, String pType, double pArea, Date pDate, String pCommunity
        ArrayList<String> placesNames = controller.placesToString();
        int validity = 0;
        String nom = "";
        do {
            System.out.println("\nNew Place \nName: ");
            nom = sc.nextLine();
            for (int i = 0; i < placesNames.size(); i++) {
                if (placesNames.get(i).equals(nom)) {
                    System.out.println("That place already exists. Please add another one");
                    i = placesNames.size() + 1;
                    validity = 1;
                }
            }
        } while (validity != 0);
        int entry = askUserInput("\nType of place \n(1) Area protegida \n(2) Parque Nacional \n(3) Privado", 3);
        String tipo = "";
        switch (entry) {
            case 1:
                tipo = "PROTEGIDA";
                break;

            case 2:
                tipo = "PARQUE_NACIONAL";
                break;

            case 3:
                tipo = "PRIVADO";
                break;
        }
        System.out.println("\nArea(km^2): ");
        double area = sc.nextDouble();
        sc.nextLine();
        int day = askUserInput("\nDate of Inaguration \nDay: ", 31);
        int month = askUserInput("\nMonth: ", 12);
        System.out.println("\nYear: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("\nCommunity Name: ");
        String comName = sc.nextLine();

        controller.addPlace(nom, tipo, area, day, month, year, comName);

        System.out.println("\nPlace added succesfully \n");

        placesNames = controller.placesToString();

    }

    public static void addCommunity(){
        ArrayList<String> comsNames = controller.comsToString();
        int validity = 0;
        String nom = "";
        do {
            System.out.println("\nNew Community \nName: ");
            nom = sc.nextLine();
            for (int i = 0; i < comsNames.size(); i++) {
                if (comsNames.get(i).equals(nom)) {
                    System.out.println("That community already exists. Please add another one");
                    i = comsNames.size() + 1;
                    validity = 1;
                }
            }
        } while (validity != 0);

        int entry = askUserInput("\nType of community \n(1) Indigena \n(2) Razial \n(3) Afrocolombiano", 3);
        String typeCom = "";
        switch (entry) {
            case 1:
                typeCom = "INDIGENA";
                break;

            case 2:
                typeCom = "RAZIAL";
                break;

            case 3:
                typeCom = "AFROCOLOMBIANO";
                break;
        }
        System.out.println("\nPopulation: ");
        int population = sc.nextInt();
        sc.nextLine();
        System.out.println("\nRepresentative \nName: ");
        String nomRep = sc.nextLine();
        System.out.println("\nCellphone: ");
        String cellPhone = sc.nextLine();
        entry = askUserInput(
                "\nMayor Problem \n(1) Falta de Agua Potable \n(2) Falta de Hospital\n(3) Falta de Escuela \n(4) Falta acceso a la alimentacion",
                4);
        String problem = "";
        switch (entry) {
            case 1:
                problem = "FALTA_AGUA_POTABLE";
                break;

            case 2:
                problem = "FALTA_HOSPITAL";
                break;
            case 3:
                problem = "FALTA_ESCUELA";
                break;
            case 4:
                problem = "FALTA_ACCESO_A_ALIMENTACION";
                break;
        }
        controller.addCommunity(nom, typeCom, population, nomRep, cellPhone, problem);

        System.out.println("\nCommunity created succesfully \n");
    }

    public static void speciesOperations(){
        int entry = askUserInput("\nSpecies Menu \n(1) Enter Species \n(2) Modify Species \n(3) Eliminate Species\n",
                3);
        switch (entry) {
            case 1:
                addSpecies();
                break;

            case 2:
                modifySpecies();
                break;

            case 3:
                deleteSpecies();
                break;
        }
    }

    public static void addSpecies(){
        // String nomPlace, String name, String pType, int pNumber
        ArrayList<String> placesNames = controller.placesToString();
        /////////////
        if (placesNames.get(0) == null) {
            System.out.println("No places created. Unable to add Species");
        } else {
            System.out.println("\nNew Species\nAdd to which Place: \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);

            if (controller.canAddSpecies(nom)) {
                System.out.println("Species name: ");
                String nomSpecies = sc.nextLine();
                entry = askUserInput("\nType of Species \n(1) Fauna \n(2) Flora", 2);
                String tipo = "";
                tipo = entry == 1 ? "FAUNA" : "FLORA";
                System.out.println("Number individuals: ");
                int num = sc.nextInt();
                sc.nextLine();
                controller.addSpecies(nom, nomSpecies, tipo, num);
                System.out.println("\nSpecies added succesfully \n");

            } else {
                System.out.println("The species field is full. Can no longer add species\n");
            }

        }
    }

    public static void modifySpecies(){
        ArrayList<String> placesNames = controller.placesToString();
        System.out.println("\nModify Species\nFrom which species: \n");
        for (int i = 0; i < placesNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
        }
        int entry = sc.nextInt();
        sc.nextLine();
        String nom = placesNames.get(entry - 1);
        boolean value = controller.hasSpecies(nom);
        if (value) {
            String[] speciesNames = new String[15];
            speciesNames = controller.getSpeciesNames(nom);
            System.out.println("\nModify Species: \n");
            int z = 0;
            for (int i = 0; i < 15; i++) {
                if (speciesNames[i] != null) {
                    System.out.println("(" + (z + 1) + ") " + speciesNames[i] + "\n");
                    z = z + 1;
                }
            }
            entry = sc.nextInt();
            sc.nextLine();
            String speciesName = speciesNames[entry - 1];
            // show the values before asking if modifying

            entry = askUserInput("\nEnter: \n1.To modify the type of species \n2.Do not modify ", 2);
            String type = null;
            switch (entry) {
                case 1:
                    System.out.println("\nNew Type: \n1.Animal \n2.Plant");
                    int input = sc.nextInt();
                    type = input == 1 ? "FAUNA" : "FLORA";
                    sc.nextLine();
                    break;

                default:
                    break;
            }

            entry = askUserInput("\nEnter: \n1.To modify the number of individuals \n2.Do not modify", 2);
            int num = -1;
            switch (entry) {
                case 1:
                    System.out.println("\nNew Value: ");
                    num = sc.nextInt();
                    sc.nextLine();

                    break;

                default:
                    break;
            }

            controller.modifySpecies(nom, speciesName, type, num);

            System.out.println("\nSpecies modified succesfully");
        } else {
            System.out.println("\nThis place has no species \n");
        }

    }

    public static int askUserInput(String question, int maxOption) {
        Scanner sc = new Scanner(System.in);
        int entry = -1;
        while (entry < 1 || entry > maxOption) {
            System.out.println(question);
            entry = sc.nextInt();
            if (entry < 1 || entry > maxOption) {
                System.out.println("Response is not a valid option, please choose again");
            }
        }
        sc.nextLine();
        return entry;
    }

    public static void deleteSpecies(){
        ArrayList<String> placesNames = controller.placesToString();
        System.out.println("\nDelete Species \nFrom which place: \n");
        for (int i = 0; i < placesNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
        }
        int entry = sc.nextInt();
        sc.nextLine();
        String nom = placesNames.get(entry - 1);
        boolean value = controller.hasProducts(nom);
        if (value) {
            String[] speciesNames = new String[20];
            speciesNames = controller.getSpeciesNames(nom);
            System.out.println("\nDelete Species: \n");
            for (int i = 0; i < 20; i++) {
                if (speciesNames[i] != null) {
                    System.out.println((i + 1) + ". " + speciesNames[i] + "\n");
                }

            }
            entry = sc.nextInt() - 1;
            sc.nextLine();
            controller.deleteSpecies(nom, entry);
            System.out.println("Species Deleted Succesfully \n");

        } else {
            System.out.println("\nThis place has no species \n");
        }
    }

    public static void modifyCommunity(){
        ArrayList<String> comsNames = controller.comsToString();
        if (comsNames.get(0) == null) {
            System.out.println("No communities created. Unable to modify unexisting community");
        } else {
            System.out.println("\nChoose community to modify \n");
            for (int i = 0; i < comsNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + comsNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = comsNames.get(entry - 1);
            // String pName, String pType, int pPopulation, String nameRep, String cellphone
            entry = askUserInput("\nEnter: \n1. To modify community type\n2.To not", 2);
            String tipo = null;
            if (entry == 1) {
                entry = askUserInput("\nType of community \n(1) Indigena \n(2) Razial \n(3) Afrocolombiano", 3);
                switch (entry) {
                    case 1:
                        tipo = "INDIGENA";
                        break;

                    case 2:
                        tipo = "RAZIAL";
                        break;

                    case 3:
                        tipo = "AFROCOLOMBIANO";
                        break;
                }
                entry = askUserInput("\nEnter: \n1. To modify community population\n2.To not", 2);
                int num = -1;
                if (entry == 1) {
                    System.out.println("\nNew community population: ");
                    num = sc.nextInt();
                    sc.nextLine();
                }
                entry = askUserInput("\nEnter: \n1. To modify community representatives name\n2.To not", 2);
                String nomRep = null;
                if (entry == 1) {
                    System.out.println("\nNew Representatives Name: ");
                    nomRep = sc.nextLine();

                }
                entry = askUserInput("\nEnter: \n1. To modify community representatives cellphone\n2.To not", 2);
                String cellphone = null;
                if (entry == 1) {
                    System.out.println("New Representatives Cellphone: ");
                    cellphone = sc.nextLine();
                }
            entry = askUserInput("\nEnter: \n1. To modify community's problem \n2. To not",2);
            if(entry == 1){
                entry = askUserInput("\nMayor Problem \n(1) Falta de Agua Potable \n(2) Falta de Hospital\n(3) Falta de Escuela \n(4) Falta acceso a la alimentacion", 4);
            String problem = "";
            switch (entry) {
                case 1:
                problem = "FALTA_AGUA_POTABLE";
                break;
        
            case 2:
                problem = "FALTA_HOSPITAL";
                break;
            case 3:
                problem = "FALTA_ESCUELA";
                break;
            case 4:
                problem = "FALTA_ACCESO_A_ALIMENTACION";
                break;
            }
                controller.modifyCommunity(nom, tipo, num, nomRep, cellphone, problem);
                System.out.println("Community modified succesfully");

            }

        }
    }}

    public static void modifyPlace(){
        ArrayList<String> placesNames = controller.placesToString();
        if (placesNames.get(0) == null) {
            System.out.println("No places created. Unable to modify unexisting place");
        } else {
            System.out.println("\nChoose place to modify \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);
            // String pName, String pType, double pArea, int day, int month, int year,
            // String pCommunity
            entry = askUserInput("\nEnter: \n1. To modify place type\n2.To not", 2);
            String tipo = null;
            if (entry == 1) {
                entry = askUserInput("\nType of place \n(1) Protected Area \n(2) Natural Park \n(3) Private", 3);
                switch (entry) {
                    case 1:
                        tipo = "PROTEGIDA";
                        break;

                    case 2:
                        tipo = "PARQUE_NACIONAL";
                        break;

                    case 3:
                        tipo = "PRIVADA";
                        break;
                }
            }
            entry = askUserInput("\nEnter: \n1. To modify place area\n2.To not", 2);
            double num = -1;
            if (entry == 1) {
                System.out.println("\nNew place area: ");
                num = sc.nextDouble();
                sc.nextLine();
            }
            entry = askUserInput("\nEnter: \n1. To modify place's inaguration date\n2.To not", 2);
            int day = -1;
            int month = -1;
            int year = -1;
            if (entry == 1) {
                day = askUserInput("New Date \nDay:", 31);
                month = askUserInput("Month: ", 12);
                System.out.println("Year: ");
                year = sc.nextInt();
                sc.nextLine();
            }

            entry = askUserInput("\nEnter: \n1. To modify place's community \n2.To not", 2);
            String comName = null;
            if (entry == 1) {
                System.out.println("New community's name: ");
                comName = sc.nextLine();
            }

            controller.modifyPlace(nom, tipo, num, day, month, year, comName);
            System.out.println("Place modified succesfully");
        }

    }

    public static void deleteCommunity(){
        ArrayList<String> comsNames = controller.comsToString();
        if (comsNames.get(0) == null) {
            System.out.println("No communities created. Unable to delete unexisting community");
        } else {
            System.out.println("\nChoose community to modify \n");
            for (int i = 0; i < comsNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + comsNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = comsNames.get(entry - 1);
            controller.deleteCommunity(nom);
            System.out.println("Community deleted succesfully");
        }

    }

    public static void deletePlace(){
        ArrayList<String> placesNames = controller.placesToString();
        if (placesNames.get(0) == null) {
            System.out.println("No places created. Unable to delete unexisting community");
        } else {
            System.out.println("\nChoose place to modify \n");
            for (int i = 0; i < placesNames.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + placesNames.get(i) + "\n");
            }
            int entry = sc.nextInt();
            sc.nextLine();
            String nom = placesNames.get(entry - 1);
            controller.deletePlace(nom);
            System.out.println("Place deleted succesfully");
        }

    }

}
