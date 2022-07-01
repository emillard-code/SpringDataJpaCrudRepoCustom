package com.project.controller;

import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CoderController {

    @Autowired
    CoderRepository repository;

}
