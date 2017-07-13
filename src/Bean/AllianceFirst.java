package Bean;

/**
 * Created by android on 2017/7/13.
 */
public class AllianceFirst {

    private String id;
    private String name;
    private String urlImage;//主图
    private String urlGoodsInfo;//详情页
    private String shopName;
    private String goodsPirce;
    private String saleNumMonth;//商品月销售
    private String commissionPercentage;//佣金百分比
    private String commissionPirce;//佣金实际价格
    private String WANGWANG;//
    private String TaobaoShortChain;//淘宝客短链
    private String TaobaoShortChainLong;//淘宝客长链
    private String TaobaoPassword;
    private int couponTotal;//优惠券总量
    private int couponRemaining;//优惠券剩余
    private String couponDenomination;//优惠券面额 满多少减
    private String couponStartTime;//优惠券开始时间
    private String couponEndTime;//优惠券结束时间
    private String urlCoupon;//优惠券连接
    private String couponPassword;//优惠券口令
    private String couponShortChain;//优惠券短链
    private boolean marketingPlan;//营销计划

    public AllianceFirst() {
    }

    public AllianceFirst(String id, String name, String urlImage, String urlGoodsInfo, String shopName, String goodsPirce, String saleNumMonth, String commissionPercentage, String commissionPirce, String WANGWANG, String taobaoShortChain, String taobaoShortChainLong, String taobaoPassword, int couponTotal, int couponRemaining, String couponDenomination, String couponStartTime, String couponEndTime, String urlCoupon, String couponPassword, String couponShortChain, boolean marketingPlan) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.urlGoodsInfo = urlGoodsInfo;
        this.shopName = shopName;
        this.goodsPirce = goodsPirce;
        this.saleNumMonth = saleNumMonth;
        this.commissionPercentage = commissionPercentage;
        this.commissionPirce = commissionPirce;
        this.WANGWANG = WANGWANG;
        TaobaoShortChain = taobaoShortChain;
        TaobaoShortChainLong = taobaoShortChainLong;
        TaobaoPassword = taobaoPassword;
        this.couponTotal = couponTotal;
        this.couponRemaining = couponRemaining;
        this.couponDenomination = couponDenomination;
        this.couponStartTime = couponStartTime;
        this.couponEndTime = couponEndTime;
        this.urlCoupon = urlCoupon;
        this.couponPassword = couponPassword;
        this.couponShortChain = couponShortChain;
        this.marketingPlan = marketingPlan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlGoodsInfo() {
        return urlGoodsInfo;
    }

    public void setUrlGoodsInfo(String urlGoodsInfo) {
        this.urlGoodsInfo = urlGoodsInfo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsPirce() {
        return goodsPirce;
    }

    public void setGoodsPirce(String goodsPirce) {
        this.goodsPirce = goodsPirce;
    }

    public String getSaleNumMonth() {
        return saleNumMonth;
    }

    public void setSaleNumMonth(String saleNumMonth) {
        this.saleNumMonth = saleNumMonth;
    }

    public String getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(String commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public String getCommissionPirce() {
        return commissionPirce;
    }

    public void setCommissionPirce(String commissionPirce) {
        this.commissionPirce = commissionPirce;
    }

    public String getWANGWANG() {
        return WANGWANG;
    }

    public void setWANGWANG(String WANGWANG) {
        this.WANGWANG = WANGWANG;
    }

    public String getTaobaoShortChain() {
        return TaobaoShortChain;
    }

    public void setTaobaoShortChain(String taobaoShortChain) {
        TaobaoShortChain = taobaoShortChain;
    }

    public String getTaobaoShortChainLong() {
        return TaobaoShortChainLong;
    }

    public void setTaobaoShortChainLong(String taobaoShortChainLong) {
        TaobaoShortChainLong = taobaoShortChainLong;
    }

    public String getTaobaoPassword() {
        return TaobaoPassword;
    }

    public void setTaobaoPassword(String taobaoPassword) {
        TaobaoPassword = taobaoPassword;
    }

    public int getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(int couponTotal) {
        this.couponTotal = couponTotal;
    }

    public int getCouponRemaining() {
        return couponRemaining;
    }

    public void setCouponRemaining(int couponRemaining) {
        this.couponRemaining = couponRemaining;
    }

    public String getCouponDenomination() {
        return couponDenomination;
    }

    public void setCouponDenomination(String couponDenomination) {
        this.couponDenomination = couponDenomination;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getUrlCoupon() {
        return urlCoupon;
    }

    public void setUrlCoupon(String urlCoupon) {
        this.urlCoupon = urlCoupon;
    }

    public String getCouponPassword() {
        return couponPassword;
    }

    public void setCouponPassword(String couponPassword) {
        this.couponPassword = couponPassword;
    }

    public String getCouponShortChain() {
        return couponShortChain;
    }

    public void setCouponShortChain(String couponShortChain) {
        this.couponShortChain = couponShortChain;
    }

    public boolean isMarketingPlan() {
        return marketingPlan;
    }

    public void setMarketingPlan(boolean marketingPlan) {
        this.marketingPlan = marketingPlan;
    }

    @Override
    public String toString() {
        return "AllianceFirst{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", urlGoodsInfo='" + urlGoodsInfo + '\'' +
                ", shopName='" + shopName + '\'' +
                ", goodsPirce='" + goodsPirce + '\'' +
                ", saleNumMonth='" + saleNumMonth + '\'' +
                ", commissionPercentage='" + commissionPercentage + '\'' +
                ", commissionPirce='" + commissionPirce + '\'' +
                ", WANGWANG='" + WANGWANG + '\'' +
                ", TaobaoShortChain='" + TaobaoShortChain + '\'' +
                ", TaobaoShortChainLong='" + TaobaoShortChainLong + '\'' +
                ", TaobaoPassword='" + TaobaoPassword + '\'' +
                ", couponTotal=" + couponTotal +
                ", couponRemaining=" + couponRemaining +
                ", couponDenomination='" + couponDenomination + '\'' +
                ", couponStartTime='" + couponStartTime + '\'' +
                ", couponEndTime='" + couponEndTime + '\'' +
                ", urlCoupon='" + urlCoupon + '\'' +
                ", couponPassword='" + couponPassword + '\'' +
                ", couponShortChain='" + couponShortChain + '\'' +
                ", marketingPlan=" + marketingPlan +
                '}';
    }
}
