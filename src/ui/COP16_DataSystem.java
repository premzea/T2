package ui;

import model.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class COP16_DataSystem {

    public static Scanner sc = new Scanner(System.in);

    public static Controller controller = new Controller();

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
                "Enter: \n1.To modify information in the COP16 database \n2.To consult information in the COP16 database \n3.Exit Application",
                3);
        return entry;
    }

    public static void administrativeMenu() {
        int entry = askUserInput(
                "\nEnter: \n1.To enter a community \n2.To enter a place \n3.To enter,modify or eliminate a product \n4.To enter a species \n5.To modify species data",
                5);
        switch (entry) {
            case 1:
                addCommunity();
                break;

            case 2:
                addPlace();
                break;

            case 3:
                productOperations();
                break;
        }

    }

    public static void consultsMenu() {

    }

    public static void productOperations() {
        int entry = askUserInput("\nProduct Menu \n(1) Enter product \n(2) Modify Product \n(3) Eliminate Product\n",
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

    public static void addProduct() {
        ArrayList<String> comsNames = controller.comsToString();
        System.out.println("\nNew Product\nAdd to which community: \n");
        for (int i = 0; i < comsNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + comsNames.get(i) + "\n");
        }
        int entry = sc.nextInt();
        sc.nextLine();
        String nom = comsNames.get(entry - 1);
        // String comName, String pName, double perNatural, String pType, boolean
        // pHandmade
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
    }

    public static void modifyProduct() {
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
            String[] productNames = new String[20];
            productNames = controller.getProductsNames(nom);
            System.out.println("\nModify Product: \n");
            int z = 0;
            for (int i = 0; i < 20; i++) {
                if (productNames[i] != null) {
                    System.out.println("(" + (z + 1) + ") " + productNames[i] + "\n");
                    z = z + 1;
                }
            }
            entry = sc.nextInt();
            sc.nextLine();
            String productName = productNames[entry - 1];
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

    public static void deleteProduct() {
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
            String[] productNames = new String[20];
            productNames = controller.getProductsNames(nom);
            System.out.println("\nDelete Product: \n");
            for (int i = 0; i < 20; i++) {
                if (productNames[i] != null) {
                    System.out.println((i + 1) + ". " + productNames[i] + "\n");
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

    public static void addPlace() {
        // String pName, String pType, double pArea, Date pDate, String pCommunity
        System.out.println("New Place \nName: ");
        String nom = sc.nextLine();
        int entry = askUserInput("\nType of place \n(1) Area protegida \n(2) Parque Nacional \n(3) Privado", 3);
        String tipo = "";
        switch (entry) {
            case 1:
                tipo = "PROTEGIDA";
                break;

            case 2:
                tipo = "PARQUENACIONAL";
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

    }

    public static void addCommunity() {
        String [] comsNames = controller.getComsNames();
        int validity = 0;
        String nom = "";
        do{
            System.out.println("\nNew Community \nName: ");
            nom = sc.nextLine();
            for(int i =0; i< comsNames.length; i++){
            if(comsNames[i].equals(nom)){
                System.out.println("That community already exists. Please add another one");
                i = comsNames.length + 1;
                validity = 1;
            }
        }
        } while(validity !=0);
        
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

        controller.addCommunity(nom, typeCom, population, nomRep, cellPhone);

        System.out.println("\nCommunity created succesfully \n");
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
}
