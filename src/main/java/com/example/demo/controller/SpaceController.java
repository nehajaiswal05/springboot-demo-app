package com.example.demo.controller;

import com.example.demo.domain.Space;
import com.example.demo.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "event/v1/space")
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createSpace(@RequestBody Space space,
                            HttpServletRequest request, HttpServletResponse response) {
        Space createdSpace = this.spaceService.createSpace(space);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdSpace.getId()).toString());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Space getSpace(@PathVariable("id") Long id,
                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        Space space = this.spaceService.getSpace(id);
        return space;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSpace(@PathVariable("id") Long id, @RequestBody Space space,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.spaceService.updateSpace(id, space);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpace(@PathVariable("id") Long id,
                            HttpServletRequest request, HttpServletResponse response) {
        this.spaceService.deleteSpace(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Space> getHostSpaces(@RequestParam Long hostId,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.spaceService.getAllSpacesForHost(hostId);
    }
}
