package company.team.vision.databaseJava.entity;

import java.util.Date;

@javax.persistence.MappedSuperclass
public abstract class BaseEntity extends
		ch.ivyteam.ivy.scripting.objects.CompositeObject {

	private static final long serialVersionUID = 5462937839787059057L;

	@javax.persistence.Column(name = "create_date")
	private java.util.Date createDate;

	@javax.persistence.Column(name = "create_by", length = 100)
	private java.lang.String createBy;

	@javax.persistence.Column(name = "update_date")
	private java.util.Date updateDate;

	@javax.persistence.Column(name = "update_by", length = 100)
	private java.lang.String updateBy;

	/**
	 * Optimistic locking version.
	 */
	@javax.persistence.Version
	@javax.persistence.Column(name = "locking_version")
	private java.lang.Integer version;

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate != null ? new Date(createDate.getTime()) : null;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate != null ? new Date(updateDate.getTime()) : null;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
}
