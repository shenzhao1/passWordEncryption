package com.company;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

public class JasyptUtil {

    private String salt = "hx024uspkidt#$u3";

    private String preStr = "ENC(";

    private String LastStr = ")";


    public String encrypt(String message) {
        SymmetricCrypto sm4 = SmUtil.sm4(salt.getBytes());
        String encryptHex = sm4.encryptHex(message);
        encryptHex = preStr+ encryptHex +LastStr;
        return encryptHex;
    }

    public String decipherer(String encryptedMessage) {
        SymmetricCrypto sm41 = SmUtil.sm4(salt.getBytes());
        encryptedMessage = encryptedMessage.substring(4, encryptedMessage.length()-1);
        String decryptStr = sm41.decryptStr(encryptedMessage, CharsetUtil.CHARSET_UTF_8);
        return decryptStr;
    }

    //以下是老的加密方式
    /*private String passKey = "hxyh9609";

    private String preStr = "ENC(";

    private String LastStr = ")";

    //加密
    public String encrypt(String plainTextString) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        //加密的算法,这个算法是默认的
        config.setAlgorithm("PBEWithMD5AndDES");
        //加密的密钥，自定义
        config.setPassword(passKey);

        standardPBEStringEncryptor.setConfig(config);
        //xxsxx是需要加密的明文
        String encryptedTextString = standardPBEStringEncryptor.encrypt(plainTextString);

        encryptedTextString = preStr+ encryptedTextString +LastStr;
        //encryptedTextString是加密后的密文
        return encryptedTextString;
    }

    //解密
    public String decipherer(String encryptedTextString) {
        encryptedTextString = encryptedTextString.substring(4, encryptedTextString.length()-1);

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        //加解密算法
        config.setAlgorithm("PBEWithMD5AndDES");
        //此处解密密钥需要和加密密钥一致
        config.setPassword(passKey);
        standardPBEStringEncryptor.setConfig(config);
        //内容为加密后的密码串
        //解密后结果
        String plainTextString = standardPBEStringEncryptor.decrypt(encryptedTextString);
        return plainTextString;
    }*/


}
