import Bean.AllianceFirst;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by android on 2017/7/14.
 */
public class DoAllianceFirst {

    private String nowTime = "";//当前的时间
    private String lostTime = "";//计算30天后的时间
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

    public DoAllianceFirst() {
        Date date = new Date();
        System.out.println(s.format(date));
        nowTime = s.format(date);
    }

    /**
     * @param allianceFirsts   所有数据
     * @param percentageString 佣金比例
     * @param nearlyDayNum     几天过期
     * @return 新的
     */
    public ArrayList<AllianceFirst> doAllianceFirst(ArrayList<AllianceFirst> allianceFirsts, String percentageString, String nearlyDayNum) {
        ArrayList<AllianceFirst> newAlliance = new ArrayList<>();
        int num = 0;//条件数
        if (!percentageString.equals("")) {//有输入佣金
            num = 1;
        }
        if (!nearlyDayNum.equals("") && num == 1) {//有输入佣金并且有时间限制
            int daysNum = Integer.parseInt(nearlyDayNum);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, daysNum);
            lostTime = s.format(c.getTime());
            num = 2;
        }
        switch (num) {
            case 0:
                newAlliance.addAll(allianceFirsts);
                return newAlliance;
            case 1:
                for (AllianceFirst allianceFirst : allianceFirsts) {//commissionPercentage
                    float percentage = Float.parseFloat(allianceFirst.getCommissionPercentage());
                    int percentage1 = Integer.parseInt(percentageString);
                    if (percentage >= percentage1) {
                        newAlliance.add(allianceFirst);
                    }
                }
                break;
            case 2:
                for (AllianceFirst allianceFirst : allianceFirsts) {//commissionPercentage
                    int percentage = Integer.parseInt(allianceFirst.getCommissionPercentage());
                    int percentage1 = Integer.parseInt(percentageString);
                    //couponEndTime
                    if (!allianceFirst.getCouponEndTime().equals("")) {
                        boolean isAtTime = dateCompare(nowTime, lostTime, allianceFirst.getCouponEndTime());
                        if (percentage >= percentage1 && isAtTime) {
                            newAlliance.add(allianceFirst);
                        }
                    }
                }
                break;
        }
        return newAlliance;
    }

    /**
     * 比较时间
     *
     * @param start  起始时间
     * @param end    结束时间
     * @param numEnd 比较结束时间
     * @return 起始时间 > 结束时间 false   起始时间 < 结束时间 true
     */
    public boolean dateCompare(String start, String numEnd, String end) {
        //设定时间的模板
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //得到指定模范的时间
        Date s = null;
        Date e = null;
        Date ne = null;
        try {
            s = sdf.parse(start);
            e = sdf.parse(end);
            ne = sdf.parse(numEnd);
        } catch (ParseException err) {
            err.printStackTrace();
        }
        //比较
        assert s != null;
        assert ne != null;
        if (s.getTime() <= ne.getTime() && e.getTime() <= ne.getTime()) {
            return true;
        } else {
            return false;
        }
    }
}
