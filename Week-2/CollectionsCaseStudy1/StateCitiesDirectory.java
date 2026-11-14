import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCitiesDirectory
{
    static HashMap<String, HashMap<String,Integer>> states = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.println("""
                    
                    1.Add a State
                    2.Add a city
                    3.Update a city population
                    4.Print population of a city
                    5.All cities population of a specific state
                    6.All cities exceeding specific threshold population
                    7.Finding state and population of a city
                    8.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    addState();
                    break;
                case 2:
                    addCity();
                    break;
                case 3:
                    updateCityPopulation();
                    break;
                case 4:
                    displayPopulationOfACity();
                    break;
                case 5:
                    allCitiesPopulationInaState();
                    break;
                case 6:
                    allCitiesExceedingThreshold();
                    break;
                case 7:
                    findStateAndPopulationByCity();
                    break;
                case 8:
                    System.exit(4);
                default:System.out.println("enter valid choice");
            }
        }
    }
    public static void addState(){
        System.out.println("Enter state name: ");
        String state = sc.next().toUpperCase();
        if(states.containsKey(state))
            System.out.println("State already exists.");
        else{
            states.put(state,new HashMap<>());
            System.out.println("State successfully added.");
        }
    }
    public static void addCity() {
        System.out.println("Enter which state this city belongs to");
        String s = sc.next().toUpperCase();
        System.out.println("Enter city name: ");
        String city = sc.next().toUpperCase();
        System.out.println("Enter city population: ");
        int population = sc.nextInt();
        if (states.containsKey(s)) {
            if(states.get(s).containsKey(city))
                System.out.println(city+" city already exists in "+s+".");
            else
                states.get(s).put(city,population);
        }
        else{
            states.put(s,new HashMap<>(Map.of(city,population)));
        }
    }
    public static void updateCityPopulation(){
        System.out.println("Enter city name: ");
        String city = sc.next().toUpperCase();
        System.out.println("Enter it's state name: ");
        String state = sc.next().toUpperCase();
        System.out.println("Enter updated city population: ");
        int population = sc.nextInt();
        if(states.containsKey(state))
        {
            if(states.get(state).containsKey(city))
                states.get(state).put(city,population);
            else
                System.out.println(city+" city doesn't exist in "+state);
        }
        else
            System.out.println(state+" state doesn't exist.");
    }
    public static void displayPopulationOfACity(){
        System.out.println("Enter city name: ");
        String city = sc.next().toUpperCase();
        System.out.println("Enter it's state name: ");
        String state = sc.next().toUpperCase();
        if(states.containsKey(state))
        {
            if(states.get(state).containsKey(city))
                System.out.println("population is "+states.get(state).get(city));
            else
                System.out.println(city+" city doesn't exist in "+state);
        }
        else
            System.out.println(state+" state doesn't exist.");
    }
    public static void allCitiesPopulationInaState(){
        System.out.println("Enter state name: ");
        String state = sc.next().toUpperCase();
        if(states.containsKey(state))
            System.out.println("State already exists.");
        else{
            states.put(state,new HashMap<>());
            System.out.println("State successfully added.");
        }
    }
}