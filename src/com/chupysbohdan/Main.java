package com.chupysbohdan;

import com.chupysbohdan.airline.Airline;
import com.chupysbohdan.airline.Visair;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void printHelp()
    {
        System.out.println("getall - show all planes");
        System.out.println("getall <lowest> <highest> - show all planes within fuel consumption");
        System.out.println("getallcapacitance - show total capacitance of airline");
        System.out.println("help - print this message");
        System.out.println("exit - exit the program");
    }

    public static void main(String[] args) throws IOException {

        char[] command = new char[100];
        Scanner scanner = new Scanner(System.in);
        int counter;
        boolean isContinue = true;

        Airline airline = new Visair();

        System.out.println("Welcome to Aircraft_info");
        printHelp();

        while(isContinue)
        {
            String com[] = scanner.nextLine().split(" ");

            switch (com[0])
            {
                case "getall":
                    if(com.length == 1)
                    {
                        airline.showAll();
                    }
                    else if(com.length == 3)
                    {
                        try{
                            airline.showWithinFuelConsumptionRange(Integer.parseInt(com[1]), Integer.parseInt(com[2])).
                                    forEach(aircraft -> System.out.println(aircraft));
                        }catch (NumberFormatException e)
                        {
                            System.out.println("The bound should be integer");
                        }
                    }
                    else
                    {
                        System.out.println("Wrong parameter. The allowed format:");
                        System.out.println("getall");
                        System.out.println("getall <lowest> <highest>");
                    }

                    break;
                case "getallcapacitance":
                    System.out.println("Total capacitance " + airline.getTotalCapacitance() +
                                        " Carrying capacitance " + airline.getTotalCarryingCapacity());
                    break;
                case "exit":
                    isContinue = false;
                    break;
                case "help":
                    printHelp();
                    break;
                default :
                    System.out.println("Wrong command");
                    System.out.println();
                    printHelp();
            }
            System.out.println("Done!");
            System.out.println();
        }
    }
}
