package org.comstudy21.myapp.board.vo;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BoardVo {
	private int seq = 0;
	private String title = null;
	private String writer = null;
	private String content = null;
	private Date regDate = null;
	private int cnt = 0;
}
