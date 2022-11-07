package Kodlama.io.Devs.api;

import Kodlama.io.Devs.business.concretes.FrameworkServiceImpl;
import Kodlama.io.Devs.business.concretes.PLanguageServiceImpl;
import Kodlama.io.Devs.business.requests.framework.CreateFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.DeleteFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.UpdateFrameworkRequest;
import Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frameworks")
public class FrameworkController {

    private FrameworkServiceImpl frameworkService;

    @Autowired
    public FrameworkController(FrameworkServiceImpl frameworkService) {
        this.frameworkService = frameworkService;
    }

    @GetMapping("/getall")
    public List<GetFrameworkResponse> getAll(){
        return frameworkService.getAll();
    }

    @PostMapping("/addframework")
    public void addFramework(@RequestBody CreateFrameworkRequest createFrameworkRequest) throws Exception{
        this.frameworkService.addFramework(createFrameworkRequest);
    }

    @DeleteMapping("/deleteframework")
    public void deleteFramework(@RequestBody DeleteFrameworkRequest deleteFrameworkRequest) throws Exception {
        frameworkService.deleteFramework(deleteFrameworkRequest);
    }

    @PutMapping("/updateframework")
   public void updateFramework(@RequestBody UpdateFrameworkRequest updateFrameworkRequest) throws Exception {
        frameworkService.updateFramework(updateFrameworkRequest);
   }

}
