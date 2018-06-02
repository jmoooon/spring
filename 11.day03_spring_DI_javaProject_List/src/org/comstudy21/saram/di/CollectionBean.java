package org.comstudy21.saram.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.lang.String;
import org.comstudy21.saram.model.Saram;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class CollectionBean {
	private List<Saram> saramList = null;
	private Set<String> saramSet = null;
	private Map<String, String> saramMap = null;
	
	private Properties saramProp = null;
	
	/*
	public List<Saram> getSaramList() {
		return saramList;
	}

	public void setSaramList(List<Saram> saramList) {
		this.saramList = saramList;
	}
	*/
	
}
