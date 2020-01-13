package com.dhcc.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhcc.user.mapper.EmployeeMapper;
import com.dhcc.user.entities.Employee;
import com.dhcc.user.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzf
 * @create 2019-12-02 10:25
 */
@Controller
public class EmployeeController {

    private String [] departments = {"研发部","财务部","人事部"};
    private Integer prevPage;
    private Integer nextPage;

    @Resource
    private EmployeeService employeeService;

    /**点击员工管理,查询所有员工*/
    @GetMapping("/emps")
    public String empsList(Model model){

        IPage<Employee> iPage = employeeService.selectPageExt(1,5);
        model.addAttribute("emps",iPage.getRecords());
        //总页数
        model.addAttribute("totalPages",iPage.getPages());
        //总记录数
        model.addAttribute("acount",iPage.getTotal());

        return "emp/list";
    }


    @GetMapping("/emps/{curPage}")
    public String getEmpListByPage(Model model, @PathVariable("curPage") Integer curPage){

        Page<Employee> page = new Page<Employee>(curPage,5);
        IPage<Employee> iPage = employeeService.selectPageExt(curPage,5);
        model.addAttribute("emps",iPage.getRecords());
        if (curPage - 1 >= 1 ){
            prevPage = curPage -1;
        }else{
            prevPage = 1;
        }
        if (curPage + 1 <= iPage.getPages()){
            nextPage = curPage + 1;
        }
        else {
            nextPage = curPage;
        }

        model.addAttribute("prevPage",prevPage);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("totalPages",iPage.getPages());
        return "emp/list";
    }

    /**员工添加页面*/
    @GetMapping("/emps/add")
    public String toAddPage(Model model){
        //放在请求域中
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**<form th:action="@{/emps/add/emp}" method="post">
     * 员工添加
     * */
    @PostMapping("emps/add/emp")
    public String addEmp(Employee employee){
        System.out.println("添加的员工的信息："+employee);

        employeeService.insertEmployee(employee);

        //重定向到员工列表页面
        return "redirect:/emps";
    }

    @GetMapping("/emp/edit/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        //回到修改页面
        return "emp/update";
    }

    /**员工修改,根据id来修改*/
    @PostMapping("/emps/emp/edit")
    public String updateEmployee(Employee employee ,Model model){

        System.out.println("修改员工的数据:"+employee);

        int ret = employeeService.updateEmployee(employee);
        if (ret > 0){
            model.addAttribute("msg","修改成功。");
            return "redirect:/emps";
        }
        else {
            model.addAttribute("msg","修改失败.");
            return "emp/update";
        }

    }

    /**员工删除*/
    @PostMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id,Model model){

        Integer ret = employeeService.deleteEmployeeById(id);
        if (ret > 0){
            model.addAttribute("msg","删除成功");
            return "redirect:/emps";
        }else {
            model.addAttribute("msg","删除失败.");
            return "redirect:/emps";
        }


    }


}


