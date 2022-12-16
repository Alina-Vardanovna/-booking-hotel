package com.example.bookinghotelcore.service.impl;

import com.example.bookinghotelcore.entity.Home;
import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.exception.HomeNotFoundException;
import com.example.bookinghotelcore.mapper.HomeMapper;
import com.example.bookinghotelcore.repository.HomeRepository;
import com.example.bookinghotelcore.service.HomeService;
import com.example.bookinghotelcore.service.UserService;
import com.example.bookinghoteldatatransfer.request.HomeRequest;
import com.example.bookinghoteldatatransfer.response.HomeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;
    private final UserService userService;
    private final HomeMapper homeMapper;

    @Override
    public Home save(HomeRequest homeRequest, long userId) {
        log.info("request from user id: {} for creating home", userId);
        User userById = userService.findById(userId);
        Home home = homeMapper.toEntity(homeRequest);
        home.setUser(userById);
        Home save = homeRepository.save(home);
        log.info("home with id: {} created successfully", save.getId());
        return save;
    }

    @Override
    public Home findById(long id) {
        log.info("Request to get home with id: {}", id);
        Home home = homeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            log.error("home with id: {} not found", id);
            throw new HomeNotFoundException("home with id: " + id + " does not exist");
        });
        log.info("successfully found home with id: {}", id);
        return home;
    }

    @Override
    public List<HomeResponse> findAll(Pageable pageable) {
        log.info("Find all Home list");
        List<Home> productList = homeRepository.findAllIsDeletedFalse(pageable);
        return productList.stream()
                .map(homeMapper::toResponse)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void deleteById(long homeId, long userId) {
        Home homeById = findByIdAndUserId(homeId, userId);
        log.info("request from user {} to delete home with id: {}", homeById.getUser().getName(), homeId);
        homeRepository.deleteById(homeById.getId());
        log.info("home with id: {} successfully  deleted", homeId);
    }

    @Override
    public Home findByIdAndUserId(long homeId, long userId) {
        log.info("request to get home with id: {}", homeId);
        Home home = homeRepository.findByIdAndUserIdAndIsDeletedFalse(homeId, userId).orElseThrow(() -> {
            log.error("home with id: {} not found", homeId);
            throw new HomeNotFoundException("home with id: " + homeId + " does not exist");
        });
        log.info("successfully found home with id: {}", homeId);
        return home;
    }

    @Override
    public List<HomeResponse> findAllByUserId(long userId, Pageable pageable) {
        log.info("Find all Home list by user id: {}", userId);
        List<Home> homeList = homeRepository.findAllByUserIdAndIsDeletedFalse(userId, pageable);
        return homeList.stream()
                .map(homeMapper::toResponse)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
