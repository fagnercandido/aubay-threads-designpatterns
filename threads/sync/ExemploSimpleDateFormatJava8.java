package threads.sync;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
    Objetivo: Reescreva o código para que fique seguro, com Java8.
*/

public class ExemploSimpleDateFormatJava8 {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args) {
        String dateStr = "2020-02-29T10:00:00";

        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                DateUtils.parseDate(dateStr, sdf);
            }
        };

        for(int i = 0; i < 2; i++) {
            new Thread(tarefa).start();
        }


    }
}

class DateUtils {
    public static void parseDate(String dateStr, SimpleDateFormat sdf) {
        try {
            Date date = sdf.parse(dateStr);
            System.out.println("Date Parseada " + date);
        } catch (ParseException e) {
            System.out.println("ParseError " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}