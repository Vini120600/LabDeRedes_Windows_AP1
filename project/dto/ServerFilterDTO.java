package org.comeia.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.comeia.project.search.SearchCriteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=false)
public @Data class ServerFilterDTO implements Serializable {

	private String name;
	private String type;
	private String address;
	private String port;
	
	public static List<SearchCriteria> buildCriteria(ServerFilterDTO filter) {
		List<SearchCriteria> criterias = new ArrayList<>();
		
		if(filter.getName() != null && !filter.getName().isEmpty()) { 
			criterias.add(new SearchCriteria("Name", "%".concat(filter.getName()).concat("%")));
		}
		
		if(filter.getType() != null && !filter.getType().isEmpty()) { 
			criterias.add(new SearchCriteria("Type", filter.getType()));
		}
		
		if(filter.getAddress() != null && !filter.getAddress().isEmpty()) { 
			criterias.add(new SearchCriteria("Address", "%".concat(filter.getAddress()).concat("%")));
		}
		
		if(filter.getPort() != null && !filter.getPort().isEmpty()) { 
			criterias.add(new SearchCriteria("Port", filter.getPort()));
		}
		
		return criterias;
	}
}
