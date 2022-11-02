package com.jiankowalski.application.api.controller;

import com.jiankowalski.application.domain.model.App;
import com.jiankowalski.application.domain.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apps")
public class ApplicationController {

    private final AppService service;

    public ApplicationController(AppService service) {
        this.service = service;
    }

    @GetMapping
    public List<App> getAllApps() {
        return service.getAllApps();
    }

    @GetMapping("/{id}")
    public App getAppById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public App createApp(@RequestBody App app) {
        return service.createApp(app);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterApp(@RequestBody App app, @PathVariable UUID id) {
//        App appSalvo = service.getById(id);
        App appUpdate = new App(id, app.getName(), app.getAddress());
        service.updateApp(appUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
