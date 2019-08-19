package com.kenect.kenectspringtest.repositories;

import com.kenect.kenectspringtest.domain.AddressInfo;
import com.kenect.kenectspringtest.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressInfo, Integer> {
}
