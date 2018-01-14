package com.slazien;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if(tonerLevel > 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.pagesPrinted = 0;
        this.isDuplex = isDuplex;
    }

    public int fillToner(int fillAmount) {
        if(fillAmount > 0 && fillAmount <= 100) {
            if(tonerLevel + fillAmount > 100) {
                return -1;
            }
            System.out.println("Filling toner...");
            tonerLevel = fillAmount;
            return tonerLevel;
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        System.out.println("Printing " + pages + " pages");
        if(isDuplex) {
            pagesToPrint = pages / 2;
            System.out.println("Printing in duplex mode");
        }
        pagesPrinted += pagesToPrint;
        return pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
