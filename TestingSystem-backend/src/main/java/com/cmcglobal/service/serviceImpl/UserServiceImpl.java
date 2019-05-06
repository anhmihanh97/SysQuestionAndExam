package com.cmcglobal.service.serviceImpl;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


//import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.entity.Exam;
import com.cmcglobal.entity.Role;
import com.cmcglobal.entity.SemesterExam;
import com.cmcglobal.entity.Test;
import com.cmcglobal.entity.User;
import com.cmcglobal.repository.CandidateRepository;
import com.cmcglobal.repository.SemesterExamRepository;
import com.cmcglobal.repository.TestRepository;
import com.cmcglobal.repository.UserRepository;
import com.cmcglobal.service.RoleService;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.service.UserService;

@Service
@PropertySource("classpath:constants.properties")
@Transactional
public class UserServiceImpl implements UserService {

//	public final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	@Autowired
	private UserRepository userRepository;
	private RoleService roleService;

	//public final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());



	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private TestRepository testRepository;
	@Autowired
	private SemesterExamRepository semesterRepo;

	@Value("${LOG4J_WARM}")
	String LOG4J_WARM;
	@Value("${LOG4J_ERROR}")
	String LOG4J_ERROR;

	@Override
	public ServiceResult getSemseterListByUserId(String id) {
		ServiceResult result = new ServiceResult();
		User user = userRepository.findById(Integer.parseInt(id)).get();
		List<Candidate> candidate = candidateRepository.findByUser(user);
		List<SemesterExam> semesters = new ArrayList<SemesterExam>();

		for (Candidate ca : candidate) {
			semesters.add(ca.getSemesterExam());
		}
		result.setData(semesters);
		return result;
	}

	@Override
	public ServiceResult getExamBySemesterExamId(String id) {
		ServiceResult result = new ServiceResult();
		SemesterExam semesterExam = semesterRepo.getOne(id);
		List<Exam> exams = new ArrayList<>();
		List<Test> list = testRepository.findBySemesterExam(semesterExam);
		for (Test test : list) {
			exams.add(test.getExam());
		}
		result.setData(exams);
		return result;
	}

	@Override
	public List<User> findAll() {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			// TODO: handle excepti
			e.printStackTrace();

		//	logger.warn(LOG4J_WARM + e);

		}
		return new LinkedList<User>();
	}

	@Override
	public User findByID(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<User> currentUser = userRepository.findById(id);
			if (currentUser.isPresent() == true) {
				return currentUser.get();
			}
		} catch (Exception e) {
			// TODO: handle exception

	//		logger.error(LOG4J_ERROR + e);

		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception

		//	logger.error(LOG4J_ERROR + e);

		}
		return false;
	}

	@Override
	public User editUser(User user, int id) {
		// TODO Auto-generated method stub
		try {
			User currentUser = userRepository.getOne(id);
			currentUser.setEmail(user.getEmail());
			currentUser.setFullName(user.getFullName());
			currentUser.setMobile(user.getMobile());
			currentUser.setStatus(user.getStatus());
			userRepository.save(currentUser);
			return currentUser;

		} catch (EntityNotFoundException e) {

		//	logger.warn(LOG4J_WARM + e);



			

		} catch (Exception e) {
			// TODO: handle exception

		//	logger.error(LOG4J_ERROR + e);

		}
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteUserByID(id);

		} catch (EntityNotFoundException e){
			//logger.warn(LOG4J_WARM + e); 
			

		} catch (Exception e) {
			// TODO: handle exception

		//	logger.error(LOG4J_ERROR + e);

		}
	}

	@Override
	public List<User> findByFullName(String keyword) {
		// TODO Auto-generated method stub
		try {
			return userRepository.findByFullname(keyword);
		} catch (Exception e) {
			// TODO: handle excepti

		//	logger.warn(LOG4J_WARM + e);

		}
		return new LinkedList<User>();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {
		//	logger.error(LOG4J_ERROR + e);

		}
		return null;
	}

	@Override
	public Boolean existsByEmail(String email) {
		try {
			Optional<User> currentUser = userRepository.findByEmail(email);
			if (currentUser.isPresent() == false) {
				return false;
			}
			userRepository.existsByEmail(email);
			return true;
		} catch (Exception e) {
		//	logger.error(LOG4J_ERROR + e);
		}
		return false;
	}

	@Override
	public void updateUserRole(User user) {
		User u = userRepository.findById(user.getUserId()).get();
		
		if (user.getStatus() == 1) {
			Set<Role> roles = user.getRoles();
			u.getRoles().addAll(roles);
		} else {
			List<Role> list = new ArrayList<Role>(user.getRoles());
			u.getRoles().removeIf(u1 -> u1.getRoleId() == list.get(0).getRoleId());

		}
		if (u != null) {
			u.setUserId(user.getUserId());
			u.setRoles(u.getRoles());
			userRepository.save(u);
		}
	}

}
