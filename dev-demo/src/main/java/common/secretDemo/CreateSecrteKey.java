package common.secretDemo; /**
 * 引进的包都是Java自带的jar包
 * 秘钥相关包
 * base64 编解码
 * 这里只用到了编码
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

public class CreateSecrteKey {


    public class Keys {

    }

    public static final String KEY_ALGORITHM = "RSA";
    //public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    //获得公钥
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //byte[] publicKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获得私钥
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //byte[] privateKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //map对象中存放公私钥
    public static Map<String, Object> initKey() throws Exception {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static void main(String[] args) {
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();
            String publicKey = getPublicKey(keyMap);
            System.out.println(publicKey);
            String privateKey = getPrivateKey(keyMap);
            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCF9SkBWkVylDVyhoC1occrw2KDwFbqUPl4yYla\n" +
            "ZiHcW0dBFgxaG5LEg0+ox/qzrcRJnhdXBhAShUErL6spDae1OrEOKFPf1Fz1tTPAKZM8BMqg6WIv\n" +
            "16E3JVS0S5h/lypBJ8jGSHDceU1cPvXJAGa/QqpFZaPNG0fcogjKzhBTkQIDAQAB";

    public static String prikey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIX1KQFaRXKUNXKGgLWhxyvDYoPA\n" +
            "VupQ+XjJiVpmIdxbR0EWDFobksSDT6jH+rOtxEmeF1cGEBKFQSsvqykNp7U6sQ4oU9/UXPW1M8Ap\n" +
            "kzwEyqDpYi/XoTclVLRLmH+XKkEnyMZIcNx5TVw+9ckAZr9CqkVlo80bR9yiCMrOEFORAgMBAAEC\n" +
            "gYAClnPOVOIWjophxftihteEHugeR27mY94N2UbP+j0ZNqIvva9LZlD1ftvhFMvhALBUA7vLsJBK\n" +
            "60wQ+4DA8ESXEkdqWln2H0CqNsuXQZwVwHFpvlVbU2TOAWQp0gsjQFmIrW0D556XPLKxSBzt6CZc\n" +
            "iqcVeK06ZaX3zzRWguZO4QJBAOwIrlOU7dG3xtMOa8WUx1B+ECfxJ6mcfNY9LwOUFVycm3WgpC3X\n" +
            "7vrfIghwVN+qiiqZszcrT08X1ZhMFB2IDpUCQQCRSgQS9qj3+JoqLDHFl9yIyk2sMGSkFW4829NL\n" +
            "DxKSjw6m5SJhRXF6zhRwT6lLJTe4SshsNLxOVo6v7OXBwb4NAkAu+2dfwbQ422DbH/K5yGyIDB/B\n" +
            "I5Jmg3yh1FnoV3CNF6smFcy4R1QNYZ7PmTR7tOF9q0xt/dPyhWcBwpr6adulAkB9xqS2QgDPAtF7\n" +
            "Vt0ToL8TUIdjXFWT0tWnK+rEHN1IMT5O7ygPK03tMUByZhQ58JNHIL5XJmQqMTa/SAcy8GV1AkEA\n" +
            "jP1q9LVqyM5qWBbj9idhUI4bUkunBQpAN5e5NRuB7aU+7X7QDQCS9Mkv3oo9hAZuBjGyiKxeJHgz\n" +
            "F5KtMsl7fw==";
}