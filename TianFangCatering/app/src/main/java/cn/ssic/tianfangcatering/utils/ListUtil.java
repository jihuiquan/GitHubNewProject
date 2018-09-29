package cn.ssic.tianfangcatering.utils;

import java.util.List;

/**
 * @package: com.ssic.yytc.utils
 * @author：JHQ
 * @date： 2018/5/18  17:09
 */
public class ListUtil {

    public static boolean isEmptyOrZero(List list) {
        if (null == list || list.size() == 0) {
            return true;
        }
        return false;
    }
}
