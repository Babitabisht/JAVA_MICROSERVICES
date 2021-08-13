package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

   public User saveUser(User user){
               return userRepository.save(user);
    }

   public User getUser(Long id){
        return userRepository.findByUserId(id);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        log.info("in get user with department");
        User user = userRepository.findByUserId(id);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(), Department.class);
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
