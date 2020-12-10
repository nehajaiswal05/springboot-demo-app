package com.example.demo.controller;

import com.example.demo.domain.Host;
import com.example.demo.domain.Space;
import com.example.demo.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "event/v1/host")
public class HostController {

    @Autowired
    HostService hostService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createHost(@RequestBody Host host,
                            HttpServletRequest request, HttpServletResponse response) {
        Host createdHost = this.hostService.createHost(host);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdHost.getId()).toString());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Host getHost(@PathVariable("id") Long id,
                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        Host host = this.hostService.getHost(id);
        return host;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHost(@PathVariable("id") Long id, @RequestBody Host host,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.hostService.updateHost(id, host);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHost(@PathVariable("id") Long id,
                            HttpServletRequest request, HttpServletResponse response) {
        this.hostService.deleteHost(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Host getHostByEmail(@RequestParam String email,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.hostService.getHostByEmail(email);
    }
}
