package com.example.demo.common.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * GO: 加密 解密
 * Created By JiWei.Chen 2018-12-29
 */
public class RSAUtil {

    final static String pub = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmKLx76pk9wsJxVRs9HZKZ3HrXg3QQL8NADpgGguK4pnIboGS7QhEP1380KChNg0ouTc7K6ximc4OTH0QAGCGFAvMoneCo1yofhJ7GmyG28Wr2PrnDAKSXOkB2etslzpY4xzAqEzJkWDK2m4O3WP3yFpUn26Zjavrrz6/uLplzl2K9xfdvqnm2uywFdSvVY/p7fTrWAAZ6hvXJuh+/9aMLpVi9BNVdft7Yku+8bIfCk1RMMbKerzHFtZKkHJ/hvTjKSiyKZAoEWfNfPUTrNJ4Wlq7WZi+2fACw/+HByUPeajPrSNorwin9jWMIid4BMnWDlZhcltjXg4HyKMorltg3wIDAQAB";
    final static String pri = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYovHvqmT3CwnFVGz0dkpnceteDdBAvw0AOmAaC4rimchugZLtCEQ/XfzQoKE2DSi5NzsrrGKZzg5MfRAAYIYUC8yid4KjXKh+EnsabIbbxavY+ucMApJc6QHZ62yXOljjHMCoTMmRYMrabg7dY/fIWlSfbpmNq+uvPr+4umXOXYr3F92+qeba7LAV1K9Vj+nt9OtYABnqG9cm6H7/1owulWL0E1V1+3tiS77xsh8KTVEwxsp6vMcW1kqQcn+G9OMpKLIpkCgRZ8189ROs0nhaWrtZmL7Z8ALD/4cHJQ95qM+tI2ivCKf2NYwiJ3gEydYOVmFyW2NeDgfIoyiuW2DfAgMBAAECggEANENW4+FMQOqepdqKlAoM3+650LKaJBFGulVCoqhhHcXaQzxKuq6h77CW6DiX+pH257RppkKYYGGVs8r+t6JVRnfj0Z1qNdV8O+7IB/wxEP9WIC2I/yvCQd3mrF9YB1ALL3ig3v+r5QNncfNNU7DvHsMPRqfwG/pJ8O9jZjUstsP3Tbjdf14ReymuOEJ1VUtmgwBp/TZBO43HbbsHjkVY5qCSZTZTu+5nkwplWgG2gnwwfAwPyKfaKqCbG22b6rhnMBQImp3AtOgPMVruk6n2QPWxr/ttDjWaBED9+W0s+s1Ue6NdMmP2TP1BHVEb0jyNGef3Ku94gALqqlhcOj2RgQKBgQDsbSut5focyG4hVlEbmdhYQVSh50btjamCKoF0LDsJQHWNLVwqYT4vCInoL4LX9/TlgFgj7eNFpeqoDfkv4U5kIjgxGsBXUKHaDu0Nitvrd1CJSib2Srjl/uaVEvFwpNkmiBZb7ik1HAEj8GmIIjWGFRbxD7/kTxQLxFoBO6+dhwKBgQClRe2E5z+dPy2uNmzhIRrSlReDmoUrbYZI/Xg7LrnSMdOd2w86kgXQfJkhRbWF/z12o2uvttYBXf8xBT/SPo/ujFVA6d4yjzUQzRsZZ93LpO8mll4x89nWG/Kt7vasVr89ts3LEVsbC0PaPzlQrgGQm3XSMFXpqaH5T1ziPSs36QKBgQC8/bfA1unMQFvowjsruRs70V153orQMkGiD6BT4Vd/2cseA3h9WCaBKm4y8GfDhC57ltDeR7c5YZvmouTi5VPor4IDnsLKCWaYDP5pqOqLm2EBngjvMGQFVnG0EOR3iw8awgY9jm/aSHyQ4gk6DT6D5C/mmxRlyODZVygrfC6x2QKBgC3bYTPnFfeDeCFGaJ9umAql44hYb2rFUOUfryR8qoJv4M+D4I3XxlU6vSJGPT+Yum0YmuB+UpK+ifgIBNVJFpaRyXXhbg2JPqgSwNojv56pfNGwFyK1DlQiHQu1qivXRejRt/gIMMcoMQN1V2nTXgvJlr9jOfNDZfXO127OmhdBAoGARrT+NLKj9g6Ar4XV9i4c3OS9XywKBl4JgppvI8VrVtEWtABZwzjzpmc7qIZfewOT0ZAAQ36CxB01g21FqHmwRkpL0cZsK+PBx/Ojk51/osZIkYvFRqAMDQxezmVKG0HamMFh/fhsiBk3wJMFk8fyQu857KGr3Wz4Dxjtx57vYgw=";

    /**
     * 生成公钥对象
     *
     * @param pubKey
     * @return
     */
    public static PublicKey getPublicKey(String pubKey) {
        byte[] keyBytes = Base64.getDecoder().decode(pubKey.getBytes());
        //解码后数据封装为对象
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(keyBytes);
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = factory.generatePublic(x509);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static PrivateKey getPrivateKey(String priKey) {

        byte[] keyBytes = Base64.getDecoder().decode(priKey.getBytes());
        //解码后数据封装为对象
        PKCS8EncodedKeySpec pkcs8 = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = factory.generatePrivate(pkcs8);
            return privateKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密数据
     *
     * @param publicKey
     * @param source
     * @return
     */
    public static String encryption(PublicKey publicKey, String source) {

        byte[] bytesEncrypt = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            bytesEncrypt = cipher.doFinal(source.getBytes());
        } catch (BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        //Base64编码
        byte[] bytesEncryptBase64 = Base64.getEncoder().encode(bytesEncrypt);
        return new String(bytesEncryptBase64);
    }


    /*
       解密数据
    */
    public static String decryption(PrivateKey privateKey, String source) {
        try {
            //Base64解码
            byte[] bytesEncrypt = Base64.getDecoder().decode(source);
            //加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytesDecrypt = cipher.doFinal(bytesEncrypt);
            return new String(bytesDecrypt);
        } catch (BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 签名
     *
     * @param privateKey
     * @param source
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, String source) {
        byte[] signed = new byte[0];
        try {
            Signature signature = Signature.getInstance("Sha1WithRSA");
            signature.initSign(privateKey);
            signature.update(source.getBytes("UTF-8"));
            signed = signature.sign();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return signed;
    }

    /**
     * 验签
     * @param publicKey
     * @param sign
     * @param source
     * @return
     */
    public static boolean verify(PublicKey publicKey, byte[] sign, String source) {
        boolean verify = false;
        try {
            Signature signature2 = Signature.getInstance("Sha1WithRSA");
            signature2.initVerify(publicKey);
            signature2.update(source.getBytes("UTF-8"));
            verify = signature2.verify(sign);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return verify;
    }

    public static void main(String[] args) {
        String source = "hello world";
        String encryption = encryption(getPublicKey(pub), source);
        System.out.println("加密数据：" + encryption);
        String decryption = decryption(getPrivateKey(pri), encryption);
        System.out.println("原始数据：" + decryption);

        byte[] sign = sign(getPrivateKey(pri), source);
        String signStr = new String(Base64.getEncoder().encode(sign));
        System.out.println("签名：" + signStr);
        System.out.println("验签：" + verify(getPublicKey(pub), Base64.getDecoder().decode(signStr.getBytes()), source));
    }
}
