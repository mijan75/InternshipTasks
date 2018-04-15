package com.example.BillPaymentAdminPanel.controller;

import com.example.BillPaymentAdminPanel.config.SecurityUtility;
import com.example.BillPaymentAdminPanel.domain.Role;
import com.example.BillPaymentAdminPanel.domain.UserRole;
import com.example.BillPaymentAdminPanel.model.BillInfo;
import com.example.BillPaymentAdminPanel.model.StakeHolder;
import com.example.BillPaymentAdminPanel.model.TempUser;
import com.example.BillPaymentAdminPanel.model.Users;
import com.example.BillPaymentAdminPanel.repository.ReportRepository;
import com.example.BillPaymentAdminPanel.repository.RoleRepository;
import com.example.BillPaymentAdminPanel.service.StakeHolderService;
import com.example.BillPaymentAdminPanel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StakeHolderService stakeHolderService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public String handleIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/access-denied";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/create")
    public ModelAndView createPage(HttpServletRequest httpServletRequest, Authentication authentication){


        Principal principal = httpServletRequest.getUserPrincipal();
        String name = principal.getName();

        String roleCheck = authentication.getAuthorities().toString();




        int stakeholderId = 0;

        Users user = userService.getUserByUsername(name);
        if(user.getStakeHolder() != null){
            stakeholderId = user.getStakeHolder().getId();
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/create");
        modelAndView.addObject("user", new Users());

        List<StakeHolder> stakeHolderList = stakeHolderService.getAll().stream().filter(s -> s.getStatus() == 1).collect(Collectors.toList());
        List<StakeHolder> mainStakeHolderList = new ArrayList<>();
        for(StakeHolder s: stakeHolderList){
            if(s.getId() == stakeholderId){
                mainStakeHolderList.add(s);
            }
        }

        if(roleCheck.equals("[ROLE_ADMIN]")){
            modelAndView.addObject("stake", stakeHolderList);
        }
        else{
            modelAndView.addObject("stake", mainStakeHolderList);
        }

        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @PostMapping("/user/save")
    public ModelAndView saveUser(HttpServletRequest request , @Valid @ModelAttribute("user") Users user, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            logger.info("Validation Error");
            modelAndView.setViewName("user/create");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        int stakeholderId = user.getTransientId();
        String userRole = user.getRole();
        user.setStatus(1);
        Optional<StakeHolder> stakeHolder = stakeHolderService.findStakeHolder(stakeholderId);
        if(stakeHolder.isPresent()){
            user.setStakeHolder(stakeHolder.get());
        }

        Optional<Role> role = roleRepository.findByRole(userRole);
        Set<UserRole> userRoles = new HashSet<>();

        if(role.isPresent()){
            userRoles.add(new UserRole(user, role.get()));
        }else {
            if(userRole.equals("ROLE_SUPER_ADMIN")){
                Role newRole = new Role();
                newRole.setRoleId(1);
                newRole.setRole("ROLE_SUPER_ADMIN");
                userRoles.add(new UserRole(user, newRole));
            }
            else if(userRole.equals("ROLE_ADMIN")){
                Role newRole = new Role();
                newRole.setRoleId(2);
                newRole.setRole("ROLE_ADMIN");
                userRoles.add(new UserRole(user, newRole));
            }
            else if(userRole.equals("ROLE_SUPER_ADMIN")){
                Role newRole = new Role();
                newRole.setRoleId(3);
                newRole.setRole("ROLE_SUPER_ADMIN");
                userRoles.add(new UserRole(user, newRole));
            }
            else if(userRole.equals("ROLE_ADMIN_REPORT")){
                Role newRole = new Role();
                newRole.setRoleId(4);
                newRole.setRole("ROLE_ADMIN_REPORT");
                userRoles.add(new UserRole(user, newRole));
            }
            else if(userRole.equals("ROLE_STAKEHOLDER_API")){
                Role newRole = new Role();
                newRole.setRoleId(5);
                newRole.setRole("ROLE_STAKEHOLDER_API");
                userRoles.add(new UserRole(user, newRole));
            }
            else if(userRole.equals("ROLE_STAKEHOLDER_REPORT")){
                Role newRole = new Role();
                newRole.setRoleId(6);
                newRole.setRole("ROLE_STAKEHOLDER_REPORT");
                userRoles.add(new UserRole(user, newRole));
            }


        }

        user.setCreated_time(new Date());
        Principal principal = request.getUserPrincipal();
        user.setCreated_by(principal.getName());

        String password = user.getPassword();
        user.setPassword(SecurityUtility.passwordEncoder().encode(password));

        userService.createUser(user, userRoles);
        userRoles.clear();
        modelAndView.setViewName("redirect:/user/lists");
        return  modelAndView;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/lists")
    public ModelAndView getAll(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userlist");
        List<Users> usersList = userService.getAll().stream().filter(u -> u.getStatus() == 1).collect(Collectors.toList());

        String roleCheck = authentication.getAuthorities().toString();

        for(int i=0; i<usersList.size(); i++){
            Set<UserRole> userRoleSet = usersList.get(i).getUserRoles();

            for(UserRole ur: userRoleSet){
                if(!roleCheck.equals("[ROLE_SUPER_ADMIN]")){
                    if(ur.getRole().getRole().equals("ROLE_SUPER_ADMIN")){
                        usersList.remove(usersList.get(i));
                    }
                }

            }
        }

        modelAndView.addObject("users", usersList);
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/edit/{id}")
    public ModelAndView editStakeHolder(@PathVariable int id){
        Optional<Users> user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/update");
        List<StakeHolder> stakeHolderList = stakeHolderService.getAll().stream().filter(s -> s.getStatus() == 1).collect(Collectors.toList());
        modelAndView.addObject("stake", stakeHolderList);


        if (user.get().getStakeHolder() != null){
            user.get().setTransientId(user.get().getStakeHolder().getId());
        }

        Set<UserRole> roleSet = user.get().getUserRoles();
        for(UserRole ur: roleSet){
            user.get().setRole(ur.getRole().getRole());
        }
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @PostMapping("/user/edit/{id}")
    public ModelAndView updateStakeHolder(HttpServletRequest request, @Valid @ModelAttribute("user") Users user, BindingResult result, @PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            logger.info("Validation errors while submitting form.");
            modelAndView.setViewName("user/update");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        int stakeholderId = user.getTransientId();
        String userRole = user.getRole();

        Optional<StakeHolder> stakeHolder = stakeHolderService.findStakeHolder(stakeholderId);
        if(stakeHolder.isPresent()){
            user.setStakeHolder(stakeHolder.get());
        }

        Set<UserRole> userRoles = new HashSet<>();

        Principal principal = request.getUserPrincipal();
        user.setUpdated_by(principal.getName());
        Optional<Users> users = userService.getUser(id);
        user.setPassword(users.get().getPassword());
        user.setUpdated_time(new Date());
        user.setId(id);

        Optional<Users> usersOptional = userService.getUser(id);
        user.setCreated_by(usersOptional.get().getCreated_by());
        user.setCreated_time(usersOptional.get().getCreated_time());

        userService.updateUser(user, userRoles);
        return new ModelAndView("redirect:/user/lists");
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/delete/{id}")
    public ModelAndView deleteStakeHolder(@PathVariable int id){
        Optional<Users> user = userService.getUser(id);
        user.get().setStatus(0);
        userService.statusUpdate(user.get(), user.get().getUserRoles());
        return new ModelAndView("redirect:/user/lists");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_REPORT')")
    @GetMapping("/user/report")
    public ModelAndView report(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reportList", reportRepository.findAll());
        modelAndView.addObject("tempUser", new TempUser());
        modelAndView.setViewName("user/report");
        return modelAndView;
    }

   @PreAuthorize("hasAnyRole('ROLE_STAKEHOLDER_REPORT')")
    @GetMapping("/user/report/stake")
    public ModelAndView stakeReport(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();


        Principal principal = request.getUserPrincipal();
        String name = principal.getName();
        Users users = userService.getUserByUsername(name);

        List<BillInfo> billInfoList = reportRepository.findAll();
        List<BillInfo> mainBillInfoList = new ArrayList<>();

        for(int i=0; i<billInfoList.size(); i++){
            if(billInfoList.get(i).getStakeHolder().getId() == users.getStakeHolder().getId()){
                mainBillInfoList.add(billInfoList.get(i));
            }
        }

        modelAndView.addObject("reportList", mainBillInfoList);
        modelAndView.setViewName("user/reportstake");
        return modelAndView;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/inactivelists")
    public ModelAndView inactiveUserLists(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/inactivelist");
        String roleCheck = authentication.getAuthorities().toString();
        List<Users> usersList = userService.getAll().stream().filter(s -> s.getStatus() == 0).collect(Collectors.toList());
        for(int i=0; i<usersList.size(); i++){
            Set<UserRole> userRoleSet = usersList.get(i).getUserRoles();

            for(UserRole ur: userRoleSet){

                if(!roleCheck.equals("[ROLE_SUPER_ADMIN]")){
                    if(ur.getRole().getRole().equals("ROLE_SUPER_ADMIN")){
                        usersList.remove(usersList.get(i));
                    }
                }
            }
        }
        modelAndView.addObject("users", usersList);
        return modelAndView;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/user/active/{id}")
    public ModelAndView activeUser(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        Optional<Users> user = userService.getUser(id);
        user.get().setStatus(1);
        userService.statusUpdate(user.get(), user.get().getUserRoles());
        return new ModelAndView("redirect:/user/inactivelists");
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_REPORT')")
    @PostMapping("/user/serchBycustomernumber")
    public ModelAndView searchById(@Valid @ModelAttribute("tempUser") TempUser tempUser, BindingResult result){
        String id = tempUser.getId();
        ModelAndView modelAndView = new ModelAndView();

        List<BillInfo> billInfoList = reportRepository.findAll();
        List<BillInfo> mainBillList = new ArrayList<>();
        for(BillInfo b: billInfoList){
            if(b.getUsers().getId() == (Integer.parseInt(id))){
                mainBillList.add(b);
            }
        }

        modelAndView.addObject("reportList", mainBillList);
        modelAndView.addObject("tempUser", new TempUser());
        modelAndView.setViewName("user/report");
        return modelAndView;
    }
}


