package com.pret.open.gate.ratelimit.config.repository.springdata;

import com.pret.open.gate.ratelimit.config.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRateLimiterRepository extends CrudRepository<Rate, String> {
    public Rate findByKey(String key);

}
