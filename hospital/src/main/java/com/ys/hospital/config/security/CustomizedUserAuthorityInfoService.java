package com.ys.hospital.config.security;

import com.ys.hospital.dao.EmployeeMapper;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.PowerDetail;
import com.ys.hospital.pojo.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomizedUserAuthorityInfoService implements UserDetailsService {
	// 存储当前用户的权限信息到session中。
	
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) { 
		//重写loadUserByUsername 方法获得 userdetails 类型用户

        Employee permissionInfo = employeeMapper.getPermissionInfo(userName);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String encodePassword = MD5Util.encode(String.valueOf(user.getPassword()));
		// 存储的密码一定要加密，否则会报异常
        String encodePassword = encoder.encode(String.valueOf(permissionInfo.getEmployeePassword()));

        //当前用户的认证信息
        CustomizedUserInfoInSecurity userPermissionDTO = new CustomizedUserInfoInSecurity();
        userPermissionDTO.setUsername(userName);
        userPermissionDTO.setPassword(encodePassword);

        //获取当前用户拥有的权限信息
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (permissionInfo != null) {
            //获取当前用户的所有角色
            List<Role> roles = permissionInfo.getRoles();
            for (int i = 0; i < roles.size(); i++) {
                Role role = roles.get(i);
                List<PowerDetail> powerDetails = roles.get(i).getPowerDetails();
                for (int j = 0; j < powerDetails.size(); j++) {
                    PowerDetail powerDetail = powerDetails.get(j);
                    if (powerDetail != null && powerDetail.getPowerDetailUrl() != null) {
                        GrantedAuthority grantedAuthority = new CustomizedGrantedAuthority(role.getRoleName(), powerDetail.getPowerDetailUrl(), powerDetail.getPowerDetailMethod());
                        grantedAuthorities.add(grantedAuthority);
                    }
                }

            }
            userPermissionDTO.setAuthorities(grantedAuthorities);
            return userPermissionDTO;
        } else {
            throw new UsernameNotFoundException("user: " + userName + " do not exist!");
        }
    }
}