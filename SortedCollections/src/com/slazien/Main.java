package com.slazien;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket myBasket = new Basket("Przemek");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);

        sellItem(myBasket, "spanner", 5);
//        System.out.println(basket);

        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 12);
        sellItem(myBasket, "bread", 1);
//        System.out.println(basket);

//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(myBasket, "car", 1);
        removeItem(myBasket, "cup", 9);
        removeItem(myBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(myBasket, "car", 1)); // should not remove any
        System.out.println(myBasket);

        // remove all items from myBasket
        removeItem(myBasket, "bread", 1);
        removeItem(myBasket, "cup", 3);
        removeItem(myBasket, "juice", 4);
        removeItem(myBasket, "cup", 3);
        System.out.println(myBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkout(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkout(myBasket);
        System.out.println(myBasket);

    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        if (stockList.reserveStock(itemName, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }

        System.out.println("There are no more " + itemName + "s in stock");
        return 0;
    }

    public static int removeItem(Basket basket, String itemName, int quantity) {
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(itemName, quantity);
        }

        System.out.println("There are no more " + itemName + "s in stock");
        return 0;
    }

    public static void checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }

        basket.clearBasket();
    }
}
