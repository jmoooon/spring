package org.comstudy21.myapp.users.model;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class users {
	private String id = null;
	private String password = null;
	private String name = null;
	private String role = null;
}
