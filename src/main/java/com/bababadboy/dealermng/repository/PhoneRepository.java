package com.bababadboy.dealermng.repository;

import com.bababadboy.dealermng.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * to deal with sql
 * @author iYmz
 *
 */
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    @Override
    List<Phone> findAll();

    @Override
    Page<Phone> findAll(Pageable pageable);

    List<Phone> findAllByLabel(String label);

    List<Phone> findAllByLabelLike(String label);

    @Query(value = "select p from Phone p where p.info like CONCAT('%',:info,'%') ")
    List<Phone> findByInfoLike(@Param("info")String info);

    List<Phone> findPhonesByMobile(String mobile);
    Phone findPhoneById(Long id);
}
