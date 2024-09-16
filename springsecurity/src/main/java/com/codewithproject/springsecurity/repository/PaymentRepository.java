package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT p.* "
            + " FROM tb_bb_payment p ", nativeQuery = true)
    List<Payment> getListPayment();

    @Query(value = "SELECT p.* "
            + " FROM tb_bb_payment p "
            + " WHERE p.id = :id ", nativeQuery = true)
    Optional<Payment> getListPaymentById(@Param("id") Integer id);
}
