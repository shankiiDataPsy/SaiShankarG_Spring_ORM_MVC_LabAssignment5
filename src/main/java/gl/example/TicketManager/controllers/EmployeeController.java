package gl.example.TicketManager.controllers;

import gl.example.TicketManager.data.Employee;
import gl.example.TicketManager.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping({"", "/", "/employee"})
    public String getAll(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "home_emp";
    }

    @GetMapping("/employee/page/add")
    public String postTicket(@ModelAttribute Employee employee, Model model){
        model.addAttribute("employee", new Employee());
        return "add_emp";
    }

    @PostMapping("/employee/post/add")
    public RedirectView postTicket(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return new RedirectView("/employee");
    }

    @GetMapping("/employee/page/edit/{employeeId}")
    public String editTicket(@PathVariable("employeeId") Long employeeId, Model model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "edit_emp";
    }

    @PostMapping("/employee/post/edit")
    public RedirectView editTicketPost(@ModelAttribute Employee employee){
        employeeService.patchEmployeeById(employee, employee.getId());
        return new RedirectView("/employee");
    }

    @GetMapping({"/employee/del/{employeeId}"})
    public RedirectView delTicket(Model model, @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new RedirectView("/employee");
    }


}
