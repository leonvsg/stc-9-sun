package ru.innopolis.stc9.sun.academy.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc9.sun.academy.dto.GroupDTO;
import ru.innopolis.stc9.sun.academy.service.GroupService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class GroupController {

    private static final String TITLE = "Управление группами";
    private final GroupService groupService;

    private static final Logger LOGGER = Logger.getLogger(SignUpController.class);

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String groups(ModelMap model) {
        Set<GroupDTO> groups = groupService.getAllGroups();

        model.addAttribute("title", TITLE);
        model.addAttribute("groups", groups);

        return "groups";
    }

    @GetMapping("/group")
    public String newGroup(ModelMap model) {
        model.addAttribute("group", new GroupDTO(0));
        model.addAttribute("title", TITLE);

        return "group";
    }

    @GetMapping("/group/{id}")
    public String updateGroup(@PathVariable Integer id, ModelMap model) {
        GroupDTO group = groupService.getGroupById(id);

        model.addAttribute("group", group);
        model.addAttribute("title", TITLE);

        return "group";
    }

    @PostMapping("/group")
    public String newGroup(@Valid @ModelAttribute("group") final GroupDTO group,
                        BindingResult bindingResult,
                        ModelMap model) {
        if (!bindingResult.hasErrors()) {
            groupService.addGroup(group);
        }
        return "group";
    }

    @PostMapping("/group/{id}")
    public String updateGroup(@Valid @ModelAttribute("group") final GroupDTO group,
                           BindingResult bindingResult,
                           ModelMap model) {
        if (!bindingResult.hasErrors()) {
            groupService.updateGroup(group);
        }
        return "group";
    }

    @GetMapping("/group/del/{id}")
    public String group(@PathVariable Integer id) {
        groupService.deleteGroupById(id);
        return "redirect:/groups";
    }
}
