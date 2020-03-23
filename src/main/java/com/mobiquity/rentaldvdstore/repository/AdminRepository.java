package com.mobiquity.rentaldvdstore.repository;

import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Dvd, Integer> {
}
