package com.example.demo.service;

import com.example.demo.domain.Host;
import com.example.demo.domain.Space;
import com.example.demo.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    HostRepository hostRepository;

    @Autowired
    SpaceService spaceService;

    @Override
    public Host getHost(Long id) {
        return hostRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    @Override
    public Host getHostByEmail(String email) {
        return hostRepository.findByEmail(email);
    }

    @Override
    public Host createHost(Host Host) {
        return hostRepository.saveAndFlush(Host);
    }

    @Override
    public Host updateHost(Long id, Host Host) {
        Host updatedHost = getHost(id);
        Optional.ofNullable(Host.getEmail()).ifPresent(updatedHost::setEmail);
        Optional.ofNullable(Host.getPassword()).ifPresent(updatedHost::setPassword);
        return hostRepository.saveAndFlush(updatedHost);
    }

    @Override
    public void deleteHost(Long id) {
        hostRepository.deleteById(id);
        List<Space> spaces = spaceService.getAllSpacesForHost(id);
        for(Space space: spaces){
            spaceService.deleteSpace(space.getId());
        }
    }
}
