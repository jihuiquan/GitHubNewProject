package cn.ssic.tianfangcatering.utils;

import java.util.UUID;

/**
 * @package: com.ssic.yytc.utils
 * @author：JHQ
 * @date： 2018/5/2  9:39
 */
public class UUIDUtil {
    public static byte[] convertUUIDToBytes(UUID uuid) {
        byte[] bytes = new byte[16];
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        for (int i = 7; i >= 0; --i) {
            bytes[i] = (byte) (msb & 0xff);
            msb >>= 8;
        }
        for (int i = 15; i >= 8; --i) {
            bytes[i] = (byte) (lsb & 0xff);
            lsb >>= 8;
        }
        return bytes;
    }

    public static UUID convertBytesToUUID(byte[] bytes) {
        long msb = 0;
        long lsb = 0;
        assert bytes.length == 16;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (bytes[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (bytes[i] & 0xff);
        }
        return new UUID(msb, lsb);
    }
}
