package com.example.birthdayreminder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class birthdayCalendar {

    private final File file;

    public birthdayCalendar(File file) {
        this.file = file;
    }

    public String checkToday() throws FileNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar today = Calendar.getInstance();
        String name=null;
        Scanner scanner = new Scanner(file);
        try {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] cols = line.split(" ");

                Date date = dateFormat.parse(cols[1]);
                Calendar birthday = Calendar.getInstance();
                birthday.setTime(date);
                if ((today.get(Calendar.DAY_OF_MONTH)) == (birthday.get(Calendar.DAY_OF_MONTH)) && (today.get(Calendar.MONTH)) == (birthday.get(Calendar.MONTH))) {
                    name = cols[0];

                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return name;
    }

    public boolean writing(String record) {
        boolean flag = false;
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(record);
            writer.append('\n');
            writer.flush();
            flag = true;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return flag;
    }

    public boolean getAll() {
        boolean flag = false;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
