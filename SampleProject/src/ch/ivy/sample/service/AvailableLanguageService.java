package ch.ivy.sample.service;

import java.util.ArrayList;
import java.util.List;

import ch.ivy.sample.dto.AvailableLanguageDTO;

public class AvailableLanguageService {
	public List<AvailableLanguageDTO> getAvailableLanguages(){
		List<AvailableLanguageDTO> availableLanguages = new ArrayList<>();
		availableLanguages.add(buildLanguage(1L, "EN", "English"));
		availableLanguages.add(buildLanguage(2L, "DE", "German"));
		availableLanguages.add(buildLanguage(3L, "FR", "French"));
		return availableLanguages;
	}
	private AvailableLanguageDTO buildLanguage(Long id, String code, String displayName){
		AvailableLanguageDTO lang = new AvailableLanguageDTO();
		lang.setCode(code);
		lang.setDescription(displayName);
		lang.setId(id);
		return lang;
	}
}
