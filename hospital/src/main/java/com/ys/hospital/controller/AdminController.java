package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.*;
import com.ys.hospital.pojo.dto.AdminEmployeeUpdateDTO;
import com.ys.hospital.pojo.dto.EmployeeAddDTO;
import com.ys.hospital.pojo.vo.EmployeeInfoVO;
import com.ys.hospital.pojo.vo.EmployeeReportVO;
import com.ys.hospital.pojo.vo.PermissionIndexVO;
import com.ys.hospital.service.*;
import com.ys.hospital.tools.BeanTool;
import com.ys.hospital.tools.InitWorkTimeTool;
import com.ys.hospital.tools.MyPageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeDetailService employeeDetailService;
    @Resource
    private DiagnosisService diagnosisService;
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private TitleService titleService;
    @Resource
    private RoleService roleService;
    @Resource
    private EmployeeRoleService employeeRoleService;
    @Resource
    private PowerService powerService;
    @Resource
    private PowerDetailService powerDetailService;
    @Resource
    private RolePowerService rolePowerService;
    @Resource
    private BranchService branchService;
    @Resource
    private InitWorkTimeTool initWorkTimeTool;

    @GetMapping("/employee")
    public EmployeeInfoVO searchEmployee(Integer employeeId) {
        // 获取某个员工
        Employee employeeDTO = employeeService.getEmployeeByEmployeeId(employeeId);
        EmployeeDetail employeeDetail = employeeDTO.getEmployeeDetail();
        Title title = employeeDetail.getTitle();


        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        BeanTool.copy(employeeDTO, employeeInfoVO);
        BeanTool.copy(employeeDetail, employeeInfoVO);
        BeanTool.copy(title, employeeInfoVO);

        return employeeInfoVO;
    }

    @PostMapping("/employee")
    public String insertEmployee(EmployeeAddDTO employeeAddDTO) {
        // 添加用户基本信息
        Employee employee = new Employee();
        employee.setEmployeeName(employeeAddDTO.getEmployeeName());
        employee.setEmployeePassword("123456");
        employeeService.insertEmployee(employee);


        // 添加用户详情
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmployeeDetailEntryTime(new Date());
        employeeDetail.setEmployeeDetailStatus(1);
        employeeDetail.setEmployeeId(employee.getEmployeeId());
        // 添加用户职称
        Title title = new Title();
        title.setTitleName(employeeAddDTO.getTitleName());
        title = titleService.queryTitleByParam(title);
        employeeDetail.setTitleId(title.getTitleId());

        // 如果有科室，添加科室
        if (!employeeAddDTO.getBranchName().isEmpty()) {
            Branch branch = new Branch();
            branch.setBranchName(employeeAddDTO.getBranchName());
            branch = branchService.queryBranchByParam(branch).get(0);
            employeeDetail.setBranchId(branch.getBranchId());
        }
        employeeDetailService.insertEmployeeDetail(employeeDetail);

        // 添加角色
        Role role = new Role();
        role.setRoleName(employeeAddDTO.getRoleName());
        role = roleService.queryRoleByParam(role);
        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setRoleId(role.getRoleId());
        employeeRole.setEmployeeId(employee.getEmployeeId());
        employeeRoleService.insertEmployeeRole(employeeRole);

        initWorkTimeTool.initWorkTime(employee.getEmployeeId());
        return "success";
    }

    @PutMapping("/employee")
    public String updateEmployee(AdminEmployeeUpdateDTO adminEmployeeUpdateDTO) {
        System.out.println("adminEmployeeUpdateDTO = " + adminEmployeeUpdateDTO);
        // 修改条件
        EmployeeDetail employeeDetail = new EmployeeDetail();

        // 修改员工基本信息
        Employee employeeDTO = new Employee();
        employeeDTO.setEmployeeId(adminEmployeeUpdateDTO.getEmployeeId());
        employeeDTO.setEmployeeName(adminEmployeeUpdateDTO.getEmployeeName());


        System.out.println("employeeDTO = " + employeeDTO);
        employeeDetail.setEmployeeId(employeeDTO.getEmployeeId());

        employeeService.updateEmployee(employeeDTO);

        // 修改员工职称
        Title title = new Title();
        BeanTool.copy(adminEmployeeUpdateDTO, title);
        title = titleService.queryTitleByParam(title);
        employeeDetail.setTitleId(title.getTitleId());

        Role role = new Role();
        BeanTool.copy(adminEmployeeUpdateDTO, role);
        role = roleService.queryRoleByParam(role);

        employeeDetailService.updateEmployeeDetailByEmployeeId(employeeDetail);
        // 修改员工角色
        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setEmployeeId(employeeDTO.getEmployeeId());
        employeeRole.setRoleId(role.getRoleId());
        employeeRole = employeeRoleService.queryEmployeeRoleByParam(employeeRole);
        if (employeeRole.getEmployeeRoleId() == null) {
            employeeRoleService.insertEmployeeRole(employeeRole);
        } else {
            employeeRoleService.updateEmployeeRole(employeeRole);
        }
        return "success";
    }

    @GetMapping("/employee/report")
    public EmployeeReportVO getEmployeeNumber() {
        // 获取在职员工数
        int offlineEmployeeNumber = employeeService.countEmployeeByStatus(0);
        // 获取离职员工数
        int onlineEmployeeNumber = employeeService.countEmployeeByStatus(1);
        int onlineNumber = employeeService.countOnlineEmployee(1);
        // 获取已处理诊断数
        int diagnosisNumber = diagnosisService.countDiagnosisByStatus("已处理");
        // 获取预约数
        int appointmentNumber = appointmentService.countAppointmentByStatus(1);

        EmployeeReportVO employeeReportVO = new EmployeeReportVO();
        employeeReportVO.setEmployeeOnlineNumber(onlineEmployeeNumber);
        employeeReportVO.setEmployeeTotalNumber(offlineEmployeeNumber + onlineEmployeeNumber);
        employeeReportVO.setDiagnosisNumber(diagnosisNumber);
        employeeReportVO.setAppointmentNumber(appointmentNumber);
        employeeReportVO.setOnlineNumber(onlineNumber);

        return employeeReportVO;
    }

    @GetMapping("/employee/online")
    public MyPageInfo<EmployeeInfoVO> searchOnlineEmployees(MyPageInfo<EmployeeInfoVO> myPageInfo) {
        // 获取所有在线的员工
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        List<EmployeeInfoVO> employeeInfoVOs = new ArrayList<>();
        employeeInfoVOs = employeeService.findEmployeeByLoginStatus(1);

        // System.out.println("employeeInfoVOs = " + employeeInfoVOs);

        //处理分页信息
        myPageInfo.setData(employeeInfoVOs);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");
        return myPageInfo;
    }

    @GetMapping("/employee/offline")
    public String searchOfflineEmployees() {
        // 获取所有离线的员工

        return "success";
    }

    @DeleteMapping("/employee")
    public String getEmployeeNumber(Integer employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "success";
    }

    @GetMapping("/permission/detail")
    public MyPageInfo<PermissionIndexVO> getPermissionDetail(MyPageInfo<PermissionIndexVO> permissionIndex) {
        // 获取角色权限信息
        List<Role> roles = roleService.queryAllRole();
        List<PermissionIndexVO> showData = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            Role role = roles.get(i);
            PermissionIndexVO permissionIndexVO = roleService.queryRolePermissionDetail(role.getRoleId());
            showData.add(permissionIndexVO);
        }
        //处理分页信息
        permissionIndex.setData(showData);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(permissionIndex.getData());
        //设置数据数量
        permissionIndex.setCount(page.getPageSize());
        //设置成功代码
        permissionIndex.setCode("0");
        return permissionIndex;
    }

    @PostMapping("/permission/detail")
    public String insertPermissionDetail(PermissionIndexVO permissionIndexVO) {
        // 添加角色
        Role role = new Role();
        Role roleTemp = new Role();
        role.setRoleName(permissionIndexVO.getRoleName());
        roleTemp = roleService.queryRoleByParam(role);
        if (roleTemp == null) {
            roleService.insertRole(role);
        } else {
            role = roleTemp;
        }

        //添加权限信息
        Power power = new Power();
        power.setPowerStatus(1);
        power.setPowerType(permissionIndexVO.getRoleName());
        powerService.insertPower(power);
        PowerDetail powerDetail = new PowerDetail();
        powerDetail.setPowerId(power.getPowerId());
        BeanTool.copy(permissionIndexVO, powerDetail);
        powerDetailService.insertPowerDetail(powerDetail);

        RolePower rolePower = new RolePower();
        rolePower.setPowerId(power.getPowerId());
        rolePower.setRoleId(role.getRoleId());
        rolePowerService.insertRolePower(rolePower);

        return "success";
    }
}