package org.comstudy21.saram.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*
@Setter
@Getter
*/
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saram {
	private String id = null;
	private String name = null;
	private int age = 0;
	
	/*
	 * setter and getter를  직접 넣지 않고 lombok 라이브러리를 사용해서 annotation으로 처리한다.
	 */
	
}
