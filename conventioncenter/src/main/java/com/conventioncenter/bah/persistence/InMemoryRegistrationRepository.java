/*package com.conventioncenter.bah.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.conventioncenter.bah.domain.Customer;
import com.conventioncenter.bah.domain.Registration;

public class InMemoryRegistrationRepository {
	private List<Registration> registrationData = new ArrayList<>(Arrays.asList(
			new Registration(1L, 1, 1, new Date(), "please email me the events details"),
			new Registration(2L, 2, 2, new Date(), "looking for info on local hotels"),
			new Registration(3L, 3, 3, new Date(), "please send logistics information"),		
			new Registration(4L, 4, 4, new Date(), "please email me the events details")
			));

	
	public Registration findById(Long id) {
		Optional<Registration> registrationOptional = registrationData.stream().filter(account -> account.getId().equals(id))
				.findAny();
		return registrationOptional.orElse(null); // Returns item if found, else returns null
	}
	
	public List<Registration> getAll(){
		return registrationData;
	}
}*/
