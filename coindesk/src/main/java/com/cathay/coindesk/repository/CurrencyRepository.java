package com.cathay.coindesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cathay.coindesk.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

	List<CurrencyEntity> findAll();

	List<CurrencyEntity> findByName(String name);

	CurrencyEntity getByName(String name);
}
