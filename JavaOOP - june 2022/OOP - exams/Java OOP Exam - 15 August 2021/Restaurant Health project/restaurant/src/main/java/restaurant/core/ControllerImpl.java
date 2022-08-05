package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalBills;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        totalBills = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        //Creates food with the correct type.
        // If the food is created successfully add it to the food repository and returns:
        //"Added {name} to the healthy menu!"
        //If a healthy food with the given name already exists in the food repository,
        // throw an IllegalArgumentException with the message "{name} is already in the healthy menu!"

        Food food = null;

        switch (type) {
            case "Salad":
                food = new Salad(name, price);
                break;
            case "VeganBiscuits":
                food = new VeganBiscuits(name, price);
                break;
        }

        if (healthFoodRepository.getAllEntities().contains(food)) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        healthFoodRepository.add(food);

        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        //Creates a beverage with the correct type. If the beverage is created successful, returns:
        //"Added {type} - {brand} to the beverage menu!"
        //If a beverage with the given name already exists in the beverage repository,
        // throw an IllegalArgumentException with the message "{name} is already in the beverage menu!"

        Beverages beverage = null;

        switch (type) {
            case "Fresh":
                beverage = new Fresh(name, counter, brand);
                break;
            case "Smoothie":
                beverage = new Smoothie(name, counter, brand);
                break;
        }

        if (beverageRepository.getAllEntities().contains(beverage)) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        beverageRepository.add(beverage);

        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //Creates a table with the correct type and returns:
        //"Added table number {number} in the healthy restaurant!"
        //If a table with the given number already exists in the table repository,
        // throw an IllegalArgumentException with the message "Table {number} is already added to the healthy restaurant!"

        Table table = null;

        switch (type) {
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                break;
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                break;
        }


        if (tableRepository.getAllEntities().contains(table)) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        //Finds a table which is not reserved, and its size is enough for the number of people provided.
        // If there is no such table returns:
        //"There is no such table for {numberOfPeople} people."
        //In the other case reserves the table and returns:
        //"Table {number} has been reserved for {numberOfPeople} people."
        Table table = tableRepository.getAllEntities()
                .stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (null == table) {

            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);

        } else {

            tableRepository.byNumber(table.getTableNumber()).reserve(numberOfPeople);

            return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //Finds the table with that number and the food with that name on the menu.
        //You first check if the table exists. If there are no such table returns:
        //"Could not find table {tableNumber}."
        //If there are no such food returns:
        //"No {healthyFoodName} in the healthy menu."
        //In other cases orders the food for that table and returns:
        //"{healthyFoodName} ordered from table {tableNumber}."

        Table table = findTable(tableNumber);

        HealthyFood food = healthFoodRepository.getAllEntities().stream()
                .filter(f -> f.getName().equals(healthyFoodName))
                .findFirst().orElse(null);


        if (!containsTable(table)) return String.format(WRONG_TABLE_NUMBER, tableNumber);

        if (null == food) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    private boolean containsTable(Table table) {
        if (table == null) {
            return false;
        }
        return true;
    }

    private Table findTable(int tableNumber) {
        Table table = tableRepository.getAllEntities().stream()
                .filter(t -> t.getTableNumber() == tableNumber)
                .findFirst().orElse(null);
        return table;
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //Finds the table with that number and find the beverage with that name and brand. 
        // You first check if the table exists. If there is no such table, it returns:
        //"Could not find table {tableNumber}."
        //If there isn’t such beverage, it returns:
        //"No {name} - {brand} in the beverage menu."
        //In another case, it orders the beverage for that table and returns:
        //"{name} ordered from table {tableNumber}."

        Table table = findTable(tableNumber);
        Beverages baverage = beverageRepository.beverageByName(name, brand);

        if (!containsTable(table)) return String.format(WRONG_TABLE_NUMBER, tableNumber);

        if (null == baverage) return String.format(NON_EXISTENT_DRINK, name, brand);

        table.orderBeverages(baverage);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        //Finds the table with the same table number.
        //Gets the bill for that table and clears it. Finally returns:
        //"Table: {tableNumber} with bill: {table bill formatted to the second digit}."

        Table table = findTable(tableNumber);

        if (!containsTable(table)) return String.format(WRONG_TABLE_NUMBER, tableNumber);

        double tableBill = table.bill();

        totalBills += tableBill;

        table.clear();

        return String.format(BILL, tableNumber, tableBill);
    }


    @Override
    public String totalMoney() {
        //Returns the money earned for the restaurant for all completed bills.
        //"Total money for the restaurant: {money formatted to the second digit}lv."


        return String.format(TOTAL_MONEY, totalBills);
    }
}
