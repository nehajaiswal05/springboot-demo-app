package com.example.demo.service;

import com.example.demo.domain.Host;
import com.example.demo.domain.Space;

import java.util.List;

public interface HostService {

    public Host getHost(Long id) throws Exception;

    public Host getHostByEmail(String email);

    public Host createHost(Host host);

    public Host updateHost(Long id, Host host) throws Exception;

    public void deleteHost(Long id);
}
