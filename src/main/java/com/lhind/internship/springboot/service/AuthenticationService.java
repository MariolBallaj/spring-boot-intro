package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.AuthenticationRequest;
import com.lhind.internship.springboot.model.dto.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}
