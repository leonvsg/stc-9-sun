package ru.innopolis.stc9.sun.academy.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc9.sun.academy.dto.GroupDTO;
import ru.innopolis.stc9.sun.academy.service.GroupService;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/group")
public class GroupController {

    private static final String TITLE = "Управление группами";
    private final GroupService groupService;

    private static final Logger LOGGER = Logger.getLogger(SignUpController.class);

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String group(ModelMap model) {
        Set<GroupDTO> groups = groupService.getAllGroups();

        model.addAttribute("title", TITLE);
        model.addAttribute("groups", groups);
        model.addAttribute("group", new GroupDTO());

        return "group";
    }

    @PostMapping
    public String group(@Valid @ModelAttribute("group") final GroupDTO group,
                         BindingResult bindingResult,
                         ModelMap model) {
        if (!bindingResult.hasErrors()) {
            if(group.getId() > 0) groupService.updateGroup(group);
            else if(group.getId() == 0) groupService.addGroup(group);
            else if(group.getId() < 0) groupService.deleteGroupById(group.getId()*(-1));
            return "redirect:/group";
        } else {
            model.addAttribute("title", TITLE);
            return "redirect:/group";
        }
    }
}
