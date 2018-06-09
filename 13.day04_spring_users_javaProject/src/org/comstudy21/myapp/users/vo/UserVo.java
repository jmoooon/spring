package org.comstudy21.myapp.users.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo {
	private String id = null;
	private String password = null;
	private String name = null;
	private String role = null;
}
