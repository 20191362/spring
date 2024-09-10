package com.anu.coupon.controller.dto;

import com.anu.coupon.domain.CouponEntity;
import com.anu.coupon.domain.CouponStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponReadResponse {
    private String couponNumber;
    private CouponStatusCode couponStatusCode;
    private LocalDateTime issuedAt;
    private LocalDateTime usedAt;
    private LocalDateTime expiredAt;

    public static CouponReadResponse fromEntity(CouponEntity coupon) {
        return new CouponReadResponse(
                coupon.getCouponNumber(),
                coupon.getCouponStatusCode(),
                coupon.getIssuedAt(),
                coupon.getUsedAt(),
                coupon.getExpiredAt()
        );
    }
}
