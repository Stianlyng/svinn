package ntnu.idatt2105.stianlyng.svinn.controller;

import ntnu.idatt2105.stianlyng.svinn.model.Demo;
import ntnu.idatt2105.stianlyng.svinn.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo2")
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewDemo (@RequestParam String name) {
        demoService.addNewDemo(name);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Demo> getAllDemos() {
        return demoService.getDemos();
    }
}