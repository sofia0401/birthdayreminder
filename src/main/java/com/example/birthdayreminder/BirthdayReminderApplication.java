package com.example.birthdayreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

public class BirthdayReminderApplication {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        File file = new File("src/main/resources/calendar.txt");
        birthdayCalendar cl=new birthdayCalendar(file);
        cl.writing("Маша 04-10-2004");
    }

}
