package com.anu.coupon.service;

import java.security.SecureRandom;

public class CouponNumberGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 12;

    public static String generate(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        // length 만큼 임의의 쿠폰 난수(문자열 대소문자 + 숫자) 생성
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));

            // 4글자마다 - 추가되는 번호
            // xxxx-xxxx-xxxx
            if ((i + 1) % 4 == 0 && i + 1 != length) {
                sb.append('-');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String couponNumber = generate(LENGTH);

        System.out.println(couponNumber);
    }

}
