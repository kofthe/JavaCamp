package Kodlama.io.Devs.api;


import Kodlama.io.Devs.business.concretes.PLanguageServiceImpl;
import Kodlama.io.Devs.business.requests.pLanguage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.RemoveLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetProgrammingLanguageResponse;
import Kodlama.io.Devs.entities.concretes.PLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planguage")
public class PLanguageController {
    PLanguageServiceImpl pLanguageServiceImpl;
    @Autowired
    public PLanguageController(PLanguageServiceImpl pLanguageServiceImpl) {
        this.pLanguageServiceImpl = pLanguageServiceImpl;
    }
    @GetMapping("/listallplanguages")
    public List<GetProgrammingLanguageResponse> gelAllPLanguages(){
        return this.pLanguageServiceImpl.getAllPLanguages();
    }
    @GetMapping("/list/{progId}")
    public GetProgrammingLanguageResponse getpLanguageById(@PathVariable int progId) {
        return this.pLanguageServiceImpl.getById(progId);
    }

    @PostMapping("/addplanguage")
    public void addLanguage(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        this.pLanguageServiceImpl.addPLanguage(createLanguageRequest);
    }

    @DeleteMapping("/deletelanguage")
    public void removepLanguage(@RequestBody RemoveLanguageRequest removeLanguageRequest) throws Exception {
        pLanguageServiceImpl.removePLanguage(removeLanguageRequest);
    }



    @PutMapping("/updatelanguage")
    public void updatepLanguage(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
        pLanguageServiceImpl.updatePLanguage(updateLanguageRequest);
    }
}
