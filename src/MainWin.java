import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by android on 2017/7/13.
 */
public class MainWin {

    private static int onePager = 7;

    public static void main(String[] args) {
        DownloadWin win = new DownloadWin("下载");

//        ShortUrlTest shortUrlTest =new ShortUrlTest();
//        shortUrlTest.getShortUrl("http://item.taobao.com/item.htm?id=550130815589");

        String string = "2017夏装新款港风潮牌polo领开叉设计宽松版套头学生短袖T恤女";
        int count = getAllPager(string.length());
        String str = "";
        for (int i = 1; i < count + 1; i++) {
            if (i==count){
                str += string.substring(0,string.length())+",";
            }else {
                str += string.substring(0,onePager*i)+",";
                if (i!=1) {
                    int i1 = i - 1;
                    str += string.substring(onePager * i1, onePager * i) + ",";
                }
            }
        }

        System.out.println(str.substring(0,str.length()-1));
    }

    /**
     * @param total 总数
     * @return 总页数
     * onePager 一页几个
     */
    public static int getAllPager(int total) {
        int pageCount = total / onePager + 1;
        if (total % onePager == 0) {
            pageCount = total / onePager;
        }
        return pageCount;
    }
}
