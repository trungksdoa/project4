/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.Exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class Timetask {

    public static void main(String[] args) {
        Timetask test = new Timetask();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd 6:00:00");
        LocalDateTime now = LocalDateTime.now();

        String date = test.getNextDate(dtf.format(now));
        Date dates = new Date(date);
        int seconds = (int) (dates.getTime() / 1000); //1440516958

//        System.out.println(seconds);
        test.TimerTask(20);
    }

    public static String getNextDate(String curDate) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd 6:00:00");
            final Date date = format.parse(curDate);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            return format.format(calendar.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(NghienCuu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void TimerTask(final int hours) {
        final Timetask test = new Timetask();
        final Timer timer = new Timer();
//        final int sec = hours * 60 * 60;
//        final int localhours = hours;
        TimerTask task = new TimerTask() {
            int counter = hours;

            @Override
            public void run() {
                if (counter > 0) {
                    System.out.println(counter + " Seconds");
                    counter--;
                } else {
                    timer.cancel();
                    try {
                        Thread.sleep(100000);
                        test.TimerTask(hours);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Timetask.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //To change body of generated methods, choose Tools | Templates.
            }
        };
        Calendar date = Calendar.getInstance();
//        timer.schedule(task, 1000);
//        System.out.println(date.getTime());
        timer.scheduleAtFixedRate(task, date.getTime(), hours);
    }

}
