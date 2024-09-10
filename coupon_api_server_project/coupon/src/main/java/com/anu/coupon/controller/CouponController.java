package com.anu.coupon.controller;

import com.anu.coupon.controller.dto.CouponReadResponse;
import com.anu.coupon.controller.dto.CouponUseRequest;
import com.anu.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupons")
public class CouponController {

    private final CouponService service;

    // HTTP Method: POST, URI: /api/v1/coupons
    @PostMapping
    public ResponseEntity<String> create() {
        String couponNumber = service.create();

        return ResponseEntity.ok(couponNumber);
    }

    @GetMapping("/{couponNumber}")
    public ResponseEntity<CouponReadResponse> getCoupon(@PathVariable String couponNumber) {
        return ResponseEntity.ok(
                service.getCoupon(couponNumber)
        );
    }

    @GetMapping
    public ResponseEntity<List<CouponReadResponse>> getCoupons() {
        return ResponseEntity.ok(
                service.getCoupons()
        );
    }

    @PostMapping("/use")
    public ResponseEntity<Void> use(@RequestBody CouponUseRequest request) {
        service.use(request.getCouponNumber());

        return ResponseEntity.ok(null);
    }


}
