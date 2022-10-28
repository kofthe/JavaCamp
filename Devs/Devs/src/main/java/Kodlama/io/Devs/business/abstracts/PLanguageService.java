package Kodlama.io.Devs.business.abstracts;


import Kodlama.io.Devs.entities.concretes.PLanguage;

import java.util.List;

public interface PLanguageService {

    List<PLanguage> getAllPLanguages();

    PLanguage getpLanguage(int progId);

    void addPLanguage(PLanguage pLanguage) throws Exception;

    void removePLanguage(int progId);

    void updatePLanguage(PLanguage pLanguage);



}
