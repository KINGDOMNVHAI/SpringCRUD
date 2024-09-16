package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT t.* "
            + " FROM tb_bb_transaction t ", nativeQuery = true)
    List<Transaction> getListTransaction();

    @Query(value = "SELECT t.* "
            + " FROM tb_bb_transaction t "
            + " WHERE t.reference LIKE :id ", nativeQuery = true)
    List<Transaction> getListTransactionById(@Param("id") String id);
}
