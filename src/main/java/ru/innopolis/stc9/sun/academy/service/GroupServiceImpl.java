package ru.innopolis.stc9.sun.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc9.sun.academy.dao.GroupDAO;
import ru.innopolis.stc9.sun.academy.dto.GroupDTO;
import ru.innopolis.stc9.sun.academy.dto.mapper.GroupMapper;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDAO groupDAO;

    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public boolean addGroup(GroupDTO groupDTO) {
        return groupDAO.add(GroupMapper.toEntity(groupDTO));
    }

    @Override
    public boolean updateGroup(GroupDTO groupDTO) { return groupDAO.update(GroupMapper.toEntity(groupDTO)); }

    @Override
    public boolean addOrUpdateGroup(GroupDTO groupDTO) { return groupDAO.addOrUpdate(GroupMapper.toEntity(groupDTO)); }

    @Override
    public boolean deleteGroupById(int id) {
        return groupDAO.deleteById(id);
    }

    @Override
    public GroupDTO getGroupById(int id) { return GroupMapper.toDto(groupDAO.getById(id)); }

    @Override
    public Set<GroupDTO> getAllGroups() {
        return groupDAO.getAll().stream().map(GroupMapper::toDto).collect(Collectors.toSet());
    }
}
