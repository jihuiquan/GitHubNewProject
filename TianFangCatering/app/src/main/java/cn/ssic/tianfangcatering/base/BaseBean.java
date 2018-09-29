package cn.ssic.tianfangcatering.base;

/**
 * @package: com.ssic.yytc.base
 * @author：JHQ
 * @date： 2018/4/25  10:57
 */
public class BaseBean<T> {

    /**
     * retCode : 100000
     * version : 1.0
     * timestamp : 1524624810770
     * data : {"loginURL":"http://192.168.1.243:8010/oauth/authorize?response_type=code&installation_id=eyJkZXZpY2VfdHlwZSI6Ik1vYmlsZSIsIm9zX3R5cGUiOiJhbmRyb2lkIiwiYWdlbnRfdHlwZSI6Ik5hdGl2ZSIsImhhcmR3YXJlX3VpZCI6eyJtb2JpbGUiOnsiSU1TSSI6Im51bGwifX19&device_info=eyJkZXZpY2VUeXBlIjoiTW9iaWxlIiwib3NUeXBlIjoid2luZG93cyIsImFnZW50VHlwZSI6IkJyb3dzZXIifQ&client_id=1&state=1&redirect_url=http://192.168.1.243:8008/schooldinner/application/login","graphicCodeURL":"http://192.168.1.243:8010/oauth/vcode/gen_graphic_vcode_image","shortMessageCodeURL":"http://192.168.1.243:8010/oauth/vcode/gen_short_message_vcode","state":"2"}
     */

    private int retCode;
    private String version;
    private String timestamp;
    private String retMsg;
    private T data;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "retCode=" + retCode +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", data=" + data +
                '}';
    }
}
