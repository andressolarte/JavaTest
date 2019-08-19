package com.kenect.kenectspringtest.repositories;

import com.kenect.kenectspringtest.domain.PhoneInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneInfoRepository extends CrudRepository<PhoneInfo, Integer> {
}
