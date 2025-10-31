package com.jad.userinterface;

import com.jad.api.UserAction;

import java.text.MessageFormat;
import java.util.Scanner;

class UserInteraction {
    public UserAction getUserPrompt() {
        for (UserAction userAction : UserAction.values()) {
            System.out.print(MessageFormat.format("({0}) ", userAction.getUserPrompt()));
        }
        System.out.println();
        System.out.println("Enter a command: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return switch (userInput) {
            case "addHumiditySensor" -> UserAction.ADD_HUMIDITY_SENSOR;
            case "addTemperatureSensor" -> UserAction.ADD_TEMPERATURE_SENSOR;
            case "addPressureSensor" -> UserAction.ADD_PRESSURE_SENSOR;
            case "addWindSpeedSensor" -> UserAction.ADD_WIND_SPEED_SENSOR;
            case "collect" -> UserAction.COLLECT;
            case "display" -> UserAction.DISPLAY;
            case "displayAll" -> UserAction.DISPLAY_ALL;
            case "reportText" -> UserAction.REPORT_TEXT;
            case "reportCSV" -> UserAction.REPORT_CSV;
            case "exit" -> UserAction.EXIT;
            case "help" -> UserAction.HELP;
            default -> {
                System.out.println("Invalid command");
                yield this.getUserPrompt();
            }
        };
    }

    public void displayHelp() {
        System.out.println("Possible commands :");
        for (UserAction userAction : UserAction.values()) {
            System.out.println(
                    MessageFormat.format(" - {0} : {1}", userAction.getUserPrompt(), userAction.getDescription()));
        }
    }
}
