package com.bb8qq.pricecoin.controller;

import com.bb8qq.pricecoin.service.NotifyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifyRestController {

    @Autowired
    private NotifyUserService userService;

    @PostMapping
    public ResponseEntity<?> addNotify(@RequestParam(name = "username") String usernaem,
                                       @RequestParam(name = "symbol") String symbol) {
        try {
            userService.addNotify(usernaem, symbol);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
