package com.cmcglobal.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.configuration.JwtProvider;
import com.cmcglobal.entity.Role;
import com.cmcglobal.entity.User;
import com.cmcglobal.repository.ConfirmationTokenRepository;
import com.cmcglobal.repository.RoleRepository;
import com.cmcglobal.repository.UserRepository;
import com.cmcglobal.service.serviceImpl.UserDetailsServiceImpl;
import com.cmcglobal.utils.Api;
import com.cmcglobal.utils.RoleName;
import com.cmcglobal.utils.request.SignUpFrom;
import com.cmcglobal.utils.response.ResponseMessage;

@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
@RequestMapping(value = Api.AuthRestAPIs.API_URL_START)
public class AuthRestAPIs {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	UserRepository userRepository;

//	@Autowired
//	EmailSenderService emailSenderService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@PostMapping(value = Api.AuthRestAPIs.API_URL_SIGNUP)
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpFrom signUpRequest) {
		// check email có tồn tại không
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Faile -> Email is already token !"),
					HttpStatus.BAD_REQUEST);
		}
		// creating users account
		// add từ SignupForm vào user
		User user = new User(signUpRequest.getEmail(), signUpRequest.getFullName(), signUpRequest.getMobile(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getStatus());
		// tạo bộ nhớ lưu trữ
		Set<String> strRoles = signUpRequest.getRole();

		Set<Role> roles = new HashSet<>();
		// kiểm tra role truộc 1 trong 3 role
		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role mng not find."));
				roles.add(adminRole);
				break;
			case "mg":
				Role mngRole = roleRepository.findByRoleName(RoleName.ROLE_MANAGER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role mng not find."));
				roles.add(mngRole);
				break;

			default:
				Role mbRole = roleRepository.findByRoleName(RoleName.ROLE_MEMBER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role mb not find."));
				roles.add(mbRole);
			}
		});
		// ---------------
		user.setRoles(roles);
		// lưu role
		userRepository.save(user);
//		ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//		confirmationTokenRepository.save(confirmationToken);
//
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(user.getEmail());
//		mailMessage.setSubject("Welcome you to RRC!");
//		mailMessage.setFrom("hiepmessi97@gmail.com");
//		mailMessage.setText("Welcome to group 3. This is a text for authentication"+
//		"<img style='width: 15%' src='https://www.cmc.com.vn/sites/default/files/screenshot_1.png' alt='cmc global' title='cmc global'> <br><br>"
//				+ "Địa chỉ: Phố Duy Tân, phường Dịch Vọng Hậu, Cầu Giấy, Hà Nội <br>"
//				+ "Tel: 04. 3 795 8668   |   Fax: 04. 3 795 8989 <br>" + "Website: http://www.cmc.com.vn");
//		emailSenderService.sendEmail(mailMessage);
		return new ResponseEntity<>(new ResponseMessage("User Registered successfully!"), HttpStatus.OK);

	}

}
