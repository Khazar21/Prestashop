package com.prestashop.tests.functional_tests.cart.positive;

public class Timing {
    public static void main(String[] args) {
        System.out.println(addMinutes("11:00 AM", 200));
    }

    public static String addMinutes(String time, int minutesToAdd) {
        int addedMinutesRemain = minutesToAdd % 60;
        int addedHours = minutesToAdd / 60;
        int hour = Integer.valueOf(time.split(":")[0]);
        int minute = Integer.valueOf(time.split(":")[1].substring(0, 2));
        String tm = time.split(":")[1].split(" ")[1];
        int resultMinutes = addedMinutesRemain + minute;
        if (resultMinutes >= 60) {
            resultMinutes = resultMinutes - 60;
            hour++;
        }
        int resultHour = hour + addedHours;

        if (resultHour >= 12) {
            if (resultHour > 12) {
                resultHour = resultHour - 12;
                if (hour != 12) {
                    tm=tm.equals("AM")?"PM":"AM";
                }else{
                    if (hour == 12){
                        if(resultMinutes==0){
                            tm=tm.equals("AM")?"PM":"AM";
                        }
                    }else{
                        resultHour = resultHour - 12;
                        if (hour != 12) {
                            tm=tm.equals("AM")?"PM":"AM";
                        }
                    }
                }
            }
        }
        if(minute+minutesToAdd>=60&&hour==12){
            tm=tm.equals("AM")?"PM":"AM";
        }
        String resultMinutesStr = (resultMinutes < 10) ? "0" + resultMinutes : resultMinutes + "";
        return resultHour + ":" + resultMinutesStr + " " + tm;
    }
}
