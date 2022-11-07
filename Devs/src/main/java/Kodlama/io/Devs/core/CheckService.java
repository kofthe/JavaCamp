package Kodlama.io.Devs.core;

import Kodlama.io.Devs.entities.concretes.Framework;
import Kodlama.io.Devs.entities.concretes.PLanguage;
import Kodlama.io.Devs.repository.abstracts.FrameworkRepository;
import Kodlama.io.Devs.repository.abstracts.PLanguageRepository;

import java.util.List;

public class CheckService {

    private PLanguageRepository pLanguageRepository;
    private FrameworkRepository frameworkRepository;

    public CheckService(PLanguageRepository pLanguageRepository, FrameworkRepository frameworkRepository) {
        this.pLanguageRepository = pLanguageRepository;
        this.frameworkRepository = frameworkRepository;
    }

    public Boolean isLanguageNameExists(PLanguage pLanguage) {
        List<PLanguage> pLanguageList = pLanguageRepository.findAll();
        for(PLanguage pLanguage2 : pLanguageList){
        if (pLanguage2.getProgName().equals(pLanguage.getProgName())) return false; }
        if (pLanguage.getProgName() == null) return false;

        return true;

    }

    public Boolean isFrameworkNameExists(Framework framework) {
        List<Framework> frameworkList = frameworkRepository.findAll();
        for (Framework framework1 : frameworkList) {
            if (framework1.getFrameworkName().equals(framework.getFrameworkName())) {
                return false;
            }
        }
        if(framework.getFrameworkName() == null) {
            return false;
        }
        return true;
    }

}
