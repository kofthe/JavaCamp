package Kodlama.io.Devs.api;


import Kodlama.io.Devs.business.concretes.PLanguageServiceImpl;
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
    public List<PLanguage> gelAllPLanguages(){
        return this.pLanguageServiceImpl.getAllPLanguages();
    }
    @GetMapping("/list/{progId}")
    public PLanguage getpLanguageById(@PathVariable int progId) {
        return this.pLanguageServiceImpl.getpLanguage(progId);
    }
    @PutMapping("/addplanguage")
    public void addLanguage(@RequestBody PLanguage pLanguage) throws Exception {
        this.pLanguageServiceImpl.addPLanguage(pLanguage);
    }
    @DeleteMapping("/deletelanguage")
    public void removepLanguage(@PathVariable int progId){
        pLanguageServiceImpl.removePLanguage(progId);
    }
    @PutMapping("/updatelanguage/{progId}")
    public void updatepLanguage(@RequestBody PLanguage pLanguage, @PathVariable int progId) {
        pLanguageServiceImpl.updatePLanguage(pLanguage);
    }
}
