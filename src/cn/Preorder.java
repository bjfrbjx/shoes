package cn;

// Generated 2019-4-22 19:53:13 by Hibernate Tools 5.4.2.Final

/**
 * Preorder generated by hbm2java
 */
public class Preorder implements java.io.Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preorderid == null) ? 0 : preorderid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preorder other = (Preorder) obj;
		if (preorderid == null) {
			if (other.preorderid != null)
				return false;
		} else if (!preorderid.equals(other.preorderid))
			return false;
		return true;
	}

	private String preorderid;
	private String userid;
	private String shoeid;

	public Preorder() {
	}

	public Preorder(String preorderid, String userid, String shoeid) {
		this.preorderid = preorderid;
		this.userid = userid;
		this.shoeid = shoeid;
	}

	public String getPreorderid() {
		return this.preorderid;
	}

	public void setPreorderid(String preorderid) {
		this.preorderid = preorderid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getShoeid() {
		return this.shoeid;
	}

	public void setShoeid(String shoeid) {
		this.shoeid = shoeid;
	}

}
