package com.marie.notification.controller;

import com.marie.notification.dto.StatusDTO;
import com.marie.notification.dto.request.StatusRequest;
import com.marie.notification.mapper.StatusDTOMapper;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.service.StatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService service;
    private final StatusDTOMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusDTO create(@Valid @RequestBody StatusRequest r){
        return mapper.apply(
                service.addStatus(r.getCustomerId(), r.getAddressType(),
                        r.getNotificationTracker(), r.getNotificationTypes()));
    }

    @GetMapping("/customer/{id}")
    public List<StatusDTO> byCustomer(@PathVariable Long id){
        return service.getStatusByCustomerId(id).stream().map(mapper).toList();
    }

    @GetMapping("/track/{track}")
    public List<StatusDTO> byTrack(@PathVariable NotificationTracker track){
        return service.getStatusByTrack(track).stream().map(mapper).toList();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestParam NotificationTracker newTrack){
        service.updateStatus(id,newTrack);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteStatus(id);
    }
}
