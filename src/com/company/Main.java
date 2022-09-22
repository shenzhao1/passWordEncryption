package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JasyptUtil jasyptUtil = new JasyptUtil();
        System.out.println(args.length);
        Scanner scanner = new Scanner(System.in);
        String operationType = "jiaMi";
        System.out.println("请输入需要进行的操作： 1代表加密； 2代表解密; 3退出程序");

        while(scanner.hasNext()){
            String scanner1 = scanner.next();
            if(scanner1.trim().equals("1")){
                operationType = "jiaMi";
                System.out.println("接下来进行加密操作->");
                break;
            }else if(scanner1.trim().equals("2")){
                System.out.println("接下来进行解密操作->");
                operationType = "jieMi";
                break;
            }else if(scanner1.trim().equals("3")){
                System.out.println("程序退出->");
                return;
            }else{
                System.out.println("请输入需要进行的操作： 1代表加密； 2代表解密; 3退出程序");
            }
        }
        if(operationType.equals("jiaMi")){
            System.out.println("请输入待加密的字符串");
            while (scanner.hasNext()){
                String jiaMiStr = scanner.next();
                if(jiaMiStr.trim().equals("3")){
                    System.out.println("程序退出->");
                    return;
                }
                if(null == jiaMiStr || jiaMiStr.trim().equals("")){
                    System.out.println("待加密的字符串为空， 请重新输入");
                }else{
                    System.out.println("加密之后的字符串为:" + jasyptUtil.encrypt(jiaMiStr));
                }
                System.out.println("如需继续加密， 请输入其他待加密的字符串， 输入3退出程序:");
            }
        }else if(operationType.equals("jieMi")){
            System.out.println("请输入待解密的字符串");
            while (scanner.hasNext()){
                String jieMiStr = scanner.next();
                if(jieMiStr.trim().equals("3")){
                    System.out.println("程序退出->");
                    return;
                }
                if(null == jieMiStr || jieMiStr.trim().equals("")){
                    System.out.println("待解密的字符串为空， 请重新输入");
                }else{
                    System.out.println("解密之后的字符串为:" + jasyptUtil.decipherer(jieMiStr));
                }
                System.out.println("如需继续解密， 请输入其他待解密的字符串， 输入3退出程序:");
            }
        }

    }
}
