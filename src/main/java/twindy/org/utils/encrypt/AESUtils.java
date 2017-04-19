package twindy.org.utils.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * 描述：AES加解密
 *
 * @author twindy
 * @time 2017-04-18
 */
public class AESUtils {

    private static final String DEFULAT_KEY = "&%1234574etUSDYA09iUSAYWQT#@!ASZASDAX)@QAWECD=&RQWADASA";

    /**
     * AES 解密
     * @param encryptValue
     * @param key
     * @return
     * @throws Exception
     */
    protected static String decrypt(String encryptValue, String key) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptValue), key);
    }

    /**
     * AES加密
     * @param value
     * @param key
     * @return
     * @throws Exception
     */
    protected static String encrypt(String value, String key) throws Exception {
        return base64Encode(aesEncryptToBytes(value, key));
    }

    private static String base64Encode(byte[] bytes){
        return Base64.encodeBase64(bytes).toString();
    }


    private static byte[] base64Decode(String base64Code) throws Exception {
        return base64Code == null ? null : Base64.decodeBase64(base64Code);
    }

    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, new SecureRandom(encryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyGen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, new SecureRandom(decryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyGen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

    public static void main(String[] args) {
        try {
            System.out.print(AESUtils.encrypt("asdasSd", "1234567897897894"));
        } catch (Exception E) {

        }

    }
}
