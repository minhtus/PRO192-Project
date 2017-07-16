/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NhanTTSE63103 - Tran Thanh Nhan
 */
class Option {
    private String menu;
    private ArrayList<String> subMenu;

    public Option() {
    }

    public Option(String menu) {
        this.menu = menu;
        this.subMenu = new ArrayList<>();
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public ArrayList<String> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(ArrayList<String> subMenu) {
        this.subMenu = subMenu;
    }
    
    public boolean addSubMenu(String s) {
        if (subMenu.add(s)) return true;
        return false;
    }
    
    public void displaySubMenu() {
        for (int i=0; i<subMenu.size(); ++i) {
            System.out.println(subMenu.get(i));
        }
    }
}

// Class Menu
public class Menu {
    private ArrayList<Option> option;

    public Menu() {
        option = new ArrayList<>();
    }
    
    /**
     * Add a menu line
     * @param s Content of the line of menu
     * @return True if adding successful
     */
    public boolean add(String s) {
        Option op = new Option(s);
        if (option.add(op)) return true;
        return false; 
    }
    
    /**
     * Add a subMenu line to a menu of given index
     * @param index Index of menu to add subMenu line
     * @param s Content of subMenu to be added
     * @return True if adding successful
     */
    public boolean addSubMenu(int index, String s) {
        if (option.get(index-1).addSubMenu(s)) return true;
        return false;
    }
    
    /**
     * Check if menu[index] has sub menu
     * @param index Index of menu line to be checked
     * @return True if menu[index] has sub menu
     */
    public boolean hasSubMenu(int index) {
        return option.get(index).getSubMenu().size() > 0;
    }
    
    /**
     * Display super menu
     */
    public void displayMenu() {
        System.out.println();
        for (int i=0; i<option.size(); ++i) {
            System.out.println(option.get(i).getMenu());
        }
    }
    
    /**
     * Display sub menu of menu[index]
     * @param index Index of menu line to be displayed
     */
    public void displaySubMenu(int index) {
        option.get(index-1).displaySubMenu();
    }
    
    /**
     * Get user choice of menu
     * @return User choice
     */
    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
