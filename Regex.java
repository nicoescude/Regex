package Clase_3;

import java.io.IOException;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Regex {

    static String pattern;
    static String cadena;
    static Scanner sc;
    static boolean flag;

    public static void run(){
        sc = new Scanner(System.in);

        //Default Values
        pattern = "[1][^2][^1]*";
        cadena  = "134";
        flag=false;

        cls();
        System.out.print("Datos Actuales: \n\t1[cadena]: "+cadena+"    \n\t2[patron]: "+pattern+"\n¿Qué desea cambiar?:");
        analizeInput();
        cls();

        while(!flag){

            if (cadena.matches(pattern))
                System.out.println(">>Cumple el Patrón!");
            else
                System.out.println(">>No Cumple el Patrón!");
            
            System.out.print("Datos Actuales: \n\t1[cadena]: "+cadena+"    \n\t2[patron]: "+pattern+"\n¿Qué desea cambiar?:");
            analizeInput();

            cls();
        }
        sc.close();
    }

    private static void analizeInput(){
        String input = sc.nextLine();

        switch(input){
            case "1":
                System.out.print("\nIngrese cadena a analizar:");
                setClipboard(cadena);
                cadena = sc.nextLine();
                break;
            case "2":
                System.out.print("\nIngrese patron a analizar:");
                setClipboard(pattern);
                pattern = sc.nextLine();
                break;
            case "0":
                flag = true;
            default:
        }
    }

    /*
        Copies 's' to the clipboard
    */

    private static void setClipboard(String s){
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    /*
        Clears Screen / Clears Console
    */
    private static void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}