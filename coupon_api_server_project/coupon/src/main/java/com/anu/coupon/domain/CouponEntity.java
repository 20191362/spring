package com.anu.coupon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "coupon")
@ToString
public class CouponEntity {

    @Id
    @Column
    private String couponNumber;

    @Enumerated(value = EnumType.STRING)
    private CouponStatusCode couponStatusCode;

    private LocalDateTime issuedAt; // 발급 시각

    private LocalDateTime usedAt; // 사용 시각

    private LocalDateTime expiredAt; // 만료 시각

    public CouponEntity(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt.plusDays(1);
    }

    // 상품정보, 발급정보, 등록일/수정일 등등

    // 쿠폰 번호를 매개변수로 받아서 쿠폰 객체를 생성하는 메서드
    public static CouponEntity of(String couponNumber) {
        return CouponEntity.builder()
                .couponNumber(couponNumber)
                .couponStatusCode(CouponStatusCode.NOT_USED)
                .issuedAt(LocalDateTime.now())
                .usedAt(null)
                .expiredAt(LocalDateTime.now().plusMonths(1))
                .build();
    }

    public void use() {
        validate();

        this.usedAt = LocalDateTime.now();
        this.couponStatusCode = CouponStatusCode.USED;
    }

    private void validate() {
        // 1. 쿠폰 상태가 사용이 되었는지 확인
        if (usedAt != null) { // 이미 사용처리가 된 경우
            throw new IllegalStateException(this.couponNumber + " 쿠폰은 이미 사용된 쿠폰입니다.");
        }

        // 2. 쿠폰이 만료되었는지 확인
        LocalDateTime now = LocalDateTime.now();

        // now = 3일, expiredAt = 2일
        if (now.isAfter(expiredAt)) {
            throw new IllegalStateException(this.couponNumber + " 쿠폰은 만료된 쿠폰입니다.");
        }

        // 유효성 검증 로직 추가 ...

        // 로직 추가 ...
    }
}
