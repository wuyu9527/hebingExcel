/**
 * Created by android on 2017/7/13.
 */
public class SplitString {
    private String splitstr;

    public SplitString() {
        // TODO 自动生成的构造函数存根
    }

    /**
     * @param httpAddress
     *  @param accordingString    * @return 返回“/”之后最后一个字符串
     */
    public String split(String splitString, String accordingString) {
        splitstr = splitString.substring(splitString.lastIndexOf(accordingString) + 1);//获取最后一个“.”之后的字符串}
        return splitstr;
    }
}
