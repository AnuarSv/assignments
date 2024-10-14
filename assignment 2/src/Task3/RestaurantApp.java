package Task3;

abstract class MenuComponent {
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.println("Item: " + getName() + ", Description: " + getDescription() + ", Price: " + getPrice());
    }
}

class Menu extends MenuComponent {
    private java.util.ArrayList<MenuComponent> menuComponents = new java.util.ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.println("Menu: " + getName() + ", Description: " + getDescription());
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}

class RestaurantApp {
    public static void main(String[] args) {
        MenuComponent lunchMenu = new Menu("Lunch Menu", "Lunch");
        MenuComponent dinnerMenu = new Menu("Dinner Menu", "Dinner");
        MenuComponent dessertMenu = new Menu("Dessert Menu", "Dessert");

        MenuComponent allMenus = new Menu("All Menus", "All restaurant menus combined");

        ((Menu) allMenus).add(lunchMenu);
        ((Menu) allMenus).add(dinnerMenu);

        ((Menu) lunchMenu).add(new MenuItem("Sandwich", "Delicious sandwich", 5.99));
        ((Menu) lunchMenu).add(new MenuItem("Salad", "Fresh salad", 3.99));

        ((Menu) dinnerMenu).add(new MenuItem("Pasta", "Tasty pasta", 8.99));
        ((Menu) dinnerMenu).add(new MenuItem("Steak", "Juicy steak", 14.99));

        ((Menu) dessertMenu).add(new MenuItem("Ice Cream", "Vanilla ice cream", 2.99));
        ((Menu) dinnerMenu).add(dessertMenu);

        allMenus.print();
    }
}
