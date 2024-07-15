package kr.co.sist.statement.vo;

public class tableVO {

	private String table;
	
	public tableVO() {
	}
	
	public tableVO(String table) {
		this.table=table;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "tableVO [table=" + table + "]";
	}

}
