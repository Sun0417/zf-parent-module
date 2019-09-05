package com.zf.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 10:28
 * Description: No Description
 */
@Component
public class TimeUtils {

    private static final String[] CN_NUMBER_NAME = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * 时间戳格式化年月日
     *
     * @param time   时间戳
     * @param format 格式化年月日类型
     * @return
     */
    public String dateFormat(long time, String format) {
        Date date = new Date(time * 1000);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取当前时间戳转换为中文年月日
     * @return
     */
    public String dateToChinese() {

        Calendar cal = Calendar.getInstance(); // 使用日历类
        String year = String.valueOf(cal.get(Calendar.YEAR)); // 得到年
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1); // 得到月，因为从0开始的，所以要加1
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)); // 得到天
        StringBuilder cnDate = new StringBuilder();
        for (int i = 0; i < year.length(); i++) {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(year.charAt(i)))]);
        }
        //得到年
        cnDate.append("年");
        for (int i = 0; i < month.length(); i++) {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(month.charAt(i)))]);
        }
        //得到月
        cnDate.append("月");
        if (day.length() == 2) {
            Integer value = Integer.valueOf(String.valueOf(day.charAt(0)));
            if (!value.equals(1)) {
                cnDate.append(CN_NUMBER_NAME[value]);
            }
            cnDate.append("十");
            if (!String.valueOf(day.charAt(1)).equals("0")) {
                cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(1)))]);
            }
        } else {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(0)))]);
        }
        //得到日
        cnDate.append("日");
        return cnDate.toString();
    }

}
