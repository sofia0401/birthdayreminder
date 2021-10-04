package com.example.birthdayreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BirthdayReminderApplication {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        File file = new File("src/main/resources/calendar.txt");
        birthdayCalendar cl=new birthdayCalendar(file);
        System.out.println("1 - узнать, чей сегодня день рождения\n" +
                "2 - добавить друга и его дату рождения\n" +
                "3 - показать всех друзей и их дни рождения\n" +
                "Введите номер команды:");
        int cmd=sc.nextInt();
        switch (cmd) {
            case 1: {
                if (cl.checkToday()==null)
                    System.out.println("Сегодня обычный день :(");
                else
                    System.out.println("Сегодня " + cl.checkToday() + " отмечает день рождения! Не забудьте поздравить");
                break;
            }
            case 2: {
                System.out.println("Введите данные в формате 'Имя ДД-ММ-ГГГГ':");
                sc.nextLine();
                String newRecord =sc.nextLine();
                if (cl.writing(newRecord))
                    System.out.println("Данные успешно добавлены");
                else
                    System.out.println("Что-то пошло не так");
                break;
            }
            case 3: {
                if (!(cl.getAll()))
                    System.out.println("Вы не сохранили ни одной даты");
                break;
            }
            default: break;
        }
    }

}
