package com.kenect.kenectspringtest.repositories;

import com.kenect.kenectspringtest.domain.EmailInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailInfoRepository extends CrudRepository<EmailInfo, Integer> {
}
