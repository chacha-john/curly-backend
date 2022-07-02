package com.chachaup.quotes.repo;

import com.chachaup.quotes.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRepo extends JpaRepository<Quote, Integer> {

}
