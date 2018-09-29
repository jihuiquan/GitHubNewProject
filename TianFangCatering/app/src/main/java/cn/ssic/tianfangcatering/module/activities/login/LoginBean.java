package cn.ssic.tianfangcatering.module.activities.login;

/**
 * @package: com.ssic.yytc.module.login
 * @author：JHQ
 * @date： 2018/4/25  11:31
 */
public class LoginBean {


    /**
     * dinnerhallID :               食堂Id
     * hpHospitalOrganizationID :   医院Id
     * accessToken : 2-65wr1zRfuRGKM0azhjRw
     * type : 3                     （1,市    2,区     3,医院）
     * refreshToken : p4Da282mQe2tRQtY7m1CTg
     */

    private String dinnerhallID;
    private String hpHospitalOrganizationID;
    private String accessToken;
    private int type;
    private String refreshToken;

    public String getDinnerhallID() {
        return dinnerhallID;
    }

    public void setDinnerhallID(String dinnerhallID) {
        this.dinnerhallID = dinnerhallID;
    }

    public String getHpHospitalOrganizationID() {
        return hpHospitalOrganizationID;
    }

    public void setHpHospitalOrganizationID(String hpHospitalOrganizationID) {
        this.hpHospitalOrganizationID = hpHospitalOrganizationID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
