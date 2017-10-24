/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author jpdw
 */
public class dateTimeMechanism {

    /**
     * Convert currant Moment to the Human date
     *
     * @return
     */
    public static String convertLongToDateStr() {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy   hh:mm");
        return format.format(d);
    }

    /**
     * Convert given Moment to the Human date
     *
     * @param moment
     * @return
     */
    public static String convertLongToDateStr(long moment) {
        Date d = new Date(moment);
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy   hh:mm");
        return format.format(d);
    }

    /**
     * Convert given Moment to the Human date, using given format string
     *
     * @param moment
     * @return
     */
    public static String convertLongToDateStr(long moment, String formatString) {
        Date d = new Date(moment);
        SimpleDateFormat format = new SimpleDateFormat(formatString);

        return format.format(d);
    }

    /**
     * Convert given Moment to the Human date, using given format string
     *
     * @param moment
     * @return
     */
    public static String convertLongToDateStr(long moment, String formatString, boolean isUTC) {
        Date d = new Date(moment);
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        if (isUTC) {
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        return format.format(d);
    }
}
