package ntnu.idatt2105.stianlyng.svinn.service;

import ntnu.idatt2105.stianlyng.svinn.model.Demo;
import ntnu.idatt2105.stianlyng.svinn.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public Iterable<Demo> getDemos() {
        return demoRepository.findAll();
    }

    public Demo addNewDemo(String name) {
        Demo demo = new Demo();
        demo.setName(name);
        return demoRepository.save(demo);
    }
}