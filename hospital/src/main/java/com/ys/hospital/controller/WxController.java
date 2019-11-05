package com.ys.hospital.controller;

import com.ys.hospital.pojo.Patient;
import com.ys.hospital.pojo.Employee;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ys.hospital.pojo.Branch;


import com.ys.hospital.pojo.*;
import com.ys.hospital.service.*;
import com.ys.hospital.tools.InitWorkTimeTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 微信小程序controller
 */
@RequestMapping("/wx")
@RestController
public class WxController {

    @Resource
    private ClientService clientService;
    @Resource
    private AiGuideService aiGuideService;
    @Resource
    private PatientService patientService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private BranchService branchService;
    @Resource
    private RoomService roomService;
    @Resource
    private WorkService workService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private TitleService titleService;
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private WorkTimeService workTimeService;
    @Resource
    private InitWorkTimeTool initWorkTimeTool;


    /**
     * 登录(返回登陆后的信息)
     *
     * @param client
     * @return Client对象:登录后的用户对象
     */
    @RequestMapping("/login")
    public Client login(Client client) {
        //检查手机号是否已经存在;存在：获取相应的信息；不存在：将手机号存入，并获取相应的用户信息
        //获取返回的client信息
        Client client1 = clientService.findClientByClient(client);
        //存在，获取信息发送到前台
        if (client1 != null) {
            return client1;
        } else {
            //将用户信息存储数据库
            return clientService.insertClient(client);
        }
    }

    /**
     * 获取账号绑定的就诊人信息
     *
     * @param clientId
     * @return list:用户绑定的就诊人列表
     */
    @RequestMapping("/getPatientListByClientId")
    public List<Patient> getPatientListByClientId(int clientId) {

        List<Patient> list = new ArrayList<>();
        list = patientService.getPatientListByClientId(clientId);
        return list;
    }

    /**
     * 智能导诊(返回回复信息)
     *
     * @param key
     * @return aiGuide:智能导诊的回复对象
     */
    @RequestMapping("/guide")
    public AiGuide guide(String key) {
        //查询智能回复信息，如果存在：返回智能表中的信息，如果不存在返回自定义信息
        AiGuide aiGuide = aiGuideService.guide(key);
        return aiGuide;
    }

    /**
     * 获取就诊人详细信息
     *
     * @param patientId
     * @return patient:就诊人对象
     */
    @RequestMapping("/getPatientDetail")
    public Patient getPatientDetailByPatientId(int patientId) {
        Patient patient = patientService.getPatientDetailByPatientId(patientId);
        return patient;
    }

    /**
     * 添加就诊人信息（返回信息为患者列表）
     *
     * @param patient
     * @return 1.null:就诊人已经被绑定无法继续绑定(返回null);2.list:绑定成功,返回用户绑定的就诊人列表
     */
    @RequestMapping("/addPatient")
    public List<Patient> addPatient(Patient patient) {
        System.out.println("=====" + patient.getClientId() + "=====");

        List<Patient> list = new ArrayList<>();
        //根据身份证号查询就诊人信息
        Patient patient1 = patientService.getPatientBypatientIdentity(patient.getPatientIdentity());
        //如果身份证对应的就诊人不存在，新增
        if (patient1 == null) {
            //新增
            patientService.addPatient(patient);
            //根据就身份证存在且clientId与传过来的clientId相同，修改
        } else if (patient1.getClientId() == patient.getClientId()) {
            //将查询到的就诊人的编号赋值给修改的就诊人
            patient.setPatientId(patient1.getPatientId());
            //根据就诊人Id修改就诊人信息
            patientService.updatePatient(patient);
        } else if (patient1.getClientId() == null) {
            //如果身份证存在且身份证没绑定账号,对其进行绑定
            patient.setPatientId(patient1.getPatientId());
            patientService.updatePatient(patient);
        } else {
            //如果身份证号存在但clientId与传过来的clientId不相同，提示已绑定其他账号，先解绑
            return list;
        }
        //返回用户绑定就诊人列表
        list = patientService.getPatientListByClientId(patient.getClientId());
        System.out.println(list.size());
        return list;
    }

    /**
     * 解绑就诊人,并返回用户就诊人列表
     *
     * @param patient
     * @return list:解绑成功,返回用户绑定的就诊人列表
     */
    @RequestMapping("/unbinding")
    public List<Patient> unbinding(Patient patient) {
        //根据就诊编号查询就诊人信息
        Patient patient1 = patientService.getPatientDetailByPatientId(patient.getPatientId());
        //将其绑定的账号设为null
        patient1.setClientId(null);
        //修改就诊人信息
        patientService.updatePatientClientId(patient1);
        //查询用户绑定的就诊人列表
        List<Patient> list = patientService.getPatientListByClientId(patient.getClientId());
        System.out.println(list.size());
        return list;
    }

    /**
     * 查询所有科信息(如内科,外科等科)
     *
     * @return list
     */
    @RequestMapping("/getDepartmentList")
    public List<Department> getDepartmentList() {
        List<Department> departmentList = departmentService.getDepartmentList();
        return departmentList;
    }

    /**
     * 根据父科的id查询其对应的子科目的列表
     *
     * @param departmentId
     * @return branchList(子科目列表)
     */
    @RequestMapping("/getBranchListByDepartmentId")
    public List<Branch> getBranchListByDepartmentId(Integer departmentId) {

        List<Branch> branchList = branchService.getBranchListByDepartmentId(departmentId);
        return branchList;
    }

    /**
     * 根据用户所选科室与日期查找值班医生
     *
     * @param branchId(科室id)
     * @param time(所选日期)
     * @return employeeList(值班医师列表)
     */
    @RequestMapping("/getDoctorListByWorkDateAndBranchId")
    public List<Employee> getDoctorListByWorkDate(Integer branchId, String time) {
        //根据科室Id与选择的时间，查询当天的值班情况
        List<Work> works = workService.findWorksByBranchIdAndTime(branchId, time);
        //存储值班医师信息的列表
        List<Employee> employees = new ArrayList<>();
        //存储医师信息对象
        Employee employee;
        //存储职称ID
        Integer titleId;
        //根据查询出来的值班医师id查询医师信息，并将其加入医师信息列表中
        for (int i = 0; i < works.size(); i++) {
            //根据查询出来的值班医师id查询医师信息
            employee = employeeService.getEmployeeByEmployeeId(works.get(i).getEmployeeId());
            //获取每个医师的职称Id
            titleId = employee.getEmployeeDetail().getTitleId();
            //将医师的职称对象加入到医师的信息中
            employee.getEmployeeDetail().setTitle(titleService.getTitleByTitleId(titleId));
            //将医师信息加入到医师信息列表中
            employees.add(employee);
        }
        return employees;
    }

    //根据值班医师Id和值班时间查询医师值班信息
    @RequestMapping("/getWorkTimeByEmployeeIdAndWorkDate")
    public Work getWorkTimeByEmployeeIdAndWorkDate(Integer employeeId, String workDate) {
//        employeeId = 2019001;
//        workDate = "2019-10-14";
//        System.out.println(employeeId + workDate);
        //获取值班表详情
        Work work = workService.findWorkByEmployeeIdAndWorkDate(employeeId, workDate);
        //查询诊室信息并将其赋值给医师值班信息
        work.setRoom(roomService.queryRoomByParam(work.getRoom()).get(0));
        return work;
    }

    /**
     * 完成支付后，生成预约单
     *
     * @param appointment(预约单内容)
     * @param time（预约时间）
     * @return 1：成功 0：失败
     */
    @RequestMapping("/addAppointment")
    public Integer addAppointment(Appointment appointment, String time) {
        //将当前时间存入支付时间属性中
        appointment.setAppointmentPayTime(new Date());
        //预约单记录存入到数据库中
        int flag = appointmentService.insertAppointment(appointment);
        //将String转换数组
        char num[] = time.toCharArray();//把字符串转换为字符数组
        System.out.println(appointment);
        //如果支付成功，将当天的余号-1
        if (flag > 0) {
            //获取日期和时间
            String day = time.substring(0, 10);
            System.out.println(appointment.getEmployeeId() + day);
            //根据日期与值班医师id查询值班表
            Work work = workService.findWorkByEmployeeIdAndWorkDate(appointment.getEmployeeId(), day);
            //获取当天时间段挂号详情
            WorkTime workTime = work.getWorkTime();
            System.out.println(workTime);
            String workDetail=null;
            //如果时间字符为15
            if(num.length==15){
                //获取时间段
               workDetail = time.substring(10, 15);
            }else if(num.length==16){
                //获取时间段
                workDetail = time.substring(11, 16);
            }

            System.out.println(workDetail);

            //根据传入的时间段决定对那个时间段的余号进行-1
            switch (workDetail) {
                case "08:00":
                    workTime.setWorkTime1((workTime.getWorkTime1() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "08:30":

                    workTime.setWorkTime2((workTime.getWorkTime2() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "09:00":
                    workTime.setWorkTime3((workTime.getWorkTime3() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "09:30":
                    workTime.setWorkTime4((workTime.getWorkTime4() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "10:00":
                    workTime.setWorkTime5((workTime.getWorkTime5() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "10:30":
                    workTime.setWorkTime6((workTime.getWorkTime6() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "11:00":
                    workTime.setWorkTime7((workTime.getWorkTime7() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "11:30":
                    workTime.setWorkTime8((workTime.getWorkTime8() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "14:00":
                    workTime.setWorkTime9((workTime.getWorkTime9() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "14:30":
                    workTime.setWorkTime10((workTime.getWorkTime10() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "15:00":
                    workTime.setWorkTime11((workTime.getWorkTime11() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "15:30":
                    workTime.setWorkTime12((workTime.getWorkTime12() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "16:00":
                    workTime.setWorkTime13((workTime.getWorkTime13() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
                case "16:30":
                    workTime.setWorkTime14((workTime.getWorkTime14() - 1));
                    workTimeService.updateWorkTime(workTime);
                    break;
            }
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 查询患者的预约记录
     *
     * @param patientId（患者Id）
     * @return appointments(患者的预约记录)
     */
    @RequestMapping("/getAppointmentListByPatientId")
    public List<Appointment> getAppointmentListByPatientId(Integer patientId) {
        //查询患者的所有预约记录
        List<Appointment> appointments = appointmentService.getAppointmentListByPatientId(patientId);
        return appointments;
    }

    /**
     * 根据预约单id查询预约单信息（级联查询）
     *
     * @param appointmentId
     * @return 预约单信息
     */
    @RequestMapping("/getAppointmentByAppointmentId")
    public Map<String, Object> getAppointmentByAppointmentId(Integer appointmentId) throws ParseException {
        System.out.println("=====" + appointmentId + "=====");

        //创建一个封装HashMap用来封装Appointment和Room
        Map<String, Object> map = new HashMap<>();
        //查询预约单的信息
        Appointment appointment = appointmentService.getAppointmentByAppointmentId(appointmentId);
        //查询出所在诊室名字

        //根据患者ID跟预约日期查找值班信息表
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String time = simpleDateFormat.format(appointment.getAppointmentTime());
        Integer employeeId = appointment.getEmployeeId();
        Work work = new Work();
        work.setWorkDate(appointment.getAppointmentTime());
        work.setEmployeeId(employeeId);
        //值班信息
        List<Work> works = workService.queryWorkByParam(work);
        System.out.println(works);
        //根据值班信息表Id获取诊室信息
        Room room = new Room();
        room.setRoomId(works.get(0).getRoomId());
        List<Room> rooms = roomService.queryRoomByParam(room);
        System.out.println(appointment);
        System.out.println("发工" + rooms.get(0));
        //将数组封装到map中
        map.put("appointment", appointment);
        map.put("room", rooms.get(0));
        return map;
    }

    @RequestMapping("/test")
    public void test() {

        System.out.println(initWorkTimeTool.initWorkTime(2019009));
    }


}
