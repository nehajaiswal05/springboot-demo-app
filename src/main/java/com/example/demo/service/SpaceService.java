package com.example.demo.service;

import com.example.demo.domain.Space;

import java.util.List;

public interface SpaceService {

    public Space getSpace(Long id) throws Exception;

    public List<Space> getAllSpacesForHost(Long hostId);

    public Space createSpace(Space space);

    public Space updateSpace(Long id, Space space) throws Exception;

    public void deleteSpace(Long id);
}
