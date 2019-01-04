package com.example.demo.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * GO: 自定义时间工具类
 * Created By JiWei.Chen 2019-01-03
 */
public class CusDateUtil {

    public static final String YMD = "yyyy-MM-dd";

    public static final String YM = "yyyy-MM";

    /**
     * 获取增减月份后的日期
     *
     * @param increment 增量
     * @param format    日期格式
     * @return
     */
    public static String getIncrementMonthDate(int increment, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        Date lastMonthDate = DateUtils.addMonths(date, increment);
        return sdf.format(lastMonthDate);
    }

    public static String getLocalDate() {
        LocalDate date = LocalDate.now();
        LocalDate lastMonth = date.plusMonths(-1);
        System.out.println("lastMonth.getMonth()"+lastMonth.getMonth().getValue());
        System.out.println("lastMonth.getYear()"+lastMonth.getYear());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String format = formatter.format(lastMonth);
        return format;
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        String tradeTime = year + "." + month;
        System.out.println(tradeTime);

/*        LocalDate parse = LocalDate.parse("2018-10-12");
        System.out.println(parse.getMonthValue());
        getIncrementMonthDate(-1, CusDateUtil.YM);
        System.out.println(getLocalDate());*/
    }
}
