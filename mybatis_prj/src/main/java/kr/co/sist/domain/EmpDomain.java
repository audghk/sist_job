package kr.co.sist.domain;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmpDomain {
  private int empno, sal, comm, deptno;
  private String ename, hiredateStr, job;
  private Date hiredate;

}
