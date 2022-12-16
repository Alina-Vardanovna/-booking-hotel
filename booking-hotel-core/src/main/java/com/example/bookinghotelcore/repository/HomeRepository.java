package com.example.bookinghotelcore.repository;

import com.example.bookinghotelcore.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface HomeRepository extends JpaRepository<Home, Integer> {

    Optional<Home> findByIdAndIsDeletedFalse(long id);

    List<Home> findAllIsDeletedFalse(Pageable pageable);

    List<Home> findAllByUserIdAndIsDeletedFalse(long userId, Pageable pageable);

    Optional<Home> findByIdAndUserIdAndIsDeletedFalse(long productId, long userId);

}
