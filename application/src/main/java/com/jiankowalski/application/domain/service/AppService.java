package com.jiankowalski.application.domain.service;

import com.jiankowalski.application.domain.model.App;
import com.jiankowalski.application.domain.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public App createApp(App app) {
        return appRepository.save(app);
    }

    public List<App> getAllApps() {
        return appRepository.findAll();
    }

    public App getById(UUID id) {
        Optional<App> app = appRepository.findById(id);
        return app.orElseThrow(RuntimeException::new);
    }

    public App getByName(String name) {
        Optional<App> app = appRepository.findByName(name);
        return app.orElseThrow(RuntimeException::new);
    }

    public App updateApp(App app) {
        return appRepository.save(app);
    }

    public void deleteById(UUID id) {
        appRepository.deleteById(id);
    }
}
