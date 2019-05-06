package com.cmcglobal.builder;

public class SemesterExamBuilder {
	private int status;
	private String name;
	private String roleName;
	private String startTime;
	private String endTime;
	private String createdDate;

	public int getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public SemesterExamBuilder(Builder builder) {
		this.status = builder.status;
		this.roleName = builder.roleName;
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.createdDate = builder.createdDate;
		this.name = builder.name;
	}

	public static class Builder {
		private int status;
		private String name;
		private String roleName;
		private String startTime;
		private String endTime;
		private String createdDate;
      
		public Builder setStatus(int status) {
			this.status = status;
			return this;
		}
        public Builder setName(String name) {
        	this.name=name;
        	return this;
        }
		public Builder setRoleName(String roleName) {
			this.roleName = roleName;
			return this;
		}
		
		public Builder setStartTime(String startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder setEndTime(String endTime) {
			
			this.endTime = endTime;
			return this;
		}

		public Builder setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
			return this;
		}
		public SemesterExamBuilder builder() {
			return new SemesterExamBuilder(this);
		}
	}

}
