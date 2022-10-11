package com.akira.reggie.service.impl;

import com.akira.reggie.entity.Employee;
import com.akira.reggie.mapper.EmployeeMapper;
import com.akira.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
}
