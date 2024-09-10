package com.anu.coupon.service;

import com.anu.coupon.controller.dto.CouponReadResponse;
import com.anu.coupon.domain.CouponEntity;
import com.anu.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository repository;

    public String create() {
        // 12자리의 쿠폰 난수 생성 (문자열 대소문자+숫자 조합), xxxx-xxxx-xxxx
        String couponNumber = CouponNumberGenerator.generate(12);

        if (couponNumber.length() == 14) {
            throw new IllegalStateException("예외 발생!");
        }

        // 쿠폰 난수를 토대로 데이터베이스에 저장할 쿠폰 객체 생성
        CouponEntity coupon = CouponEntity.of(couponNumber);

        // 데이터베이스 저장
        repository.save(coupon);

        // INSERT INTO coupon (...) VALUES (...)

        return couponNumber;
    }

    public CouponReadResponse getCoupon(String couponNumber) {
        CouponEntity coupon = repository.findById(couponNumber).orElseThrow();

        return CouponReadResponse.fromEntity(coupon);
    }

    public List<CouponReadResponse> getCoupons() {
        List<CouponEntity> coupons = repository.findAll();

        return coupons.stream()
                .map(CouponReadResponse::fromEntity)
                .toList();
    }

    public void use(String couponNumber) {
        // 쿠폰 사용 로직 작성

        // 쿠폰 조회 -> 유효성 검증 -> 쿠폰 사용 처리
        CouponEntity coupon = repository.findById(couponNumber).orElseThrow();

        coupon.use();

        repository.save(coupon);
    }

}
