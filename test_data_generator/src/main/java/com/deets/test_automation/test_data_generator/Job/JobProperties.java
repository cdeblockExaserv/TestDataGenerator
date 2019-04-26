package com.deets.test_automation.test_data_generator.Job;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.BaseProducer;

public class JobProperties {

	private JobProperties() {
		
	}
	
	public abstract static class JobProperty {
		public abstract void apply(JobProvider job, BaseProducer baseProducer);
	}
	
	public static JobProperty incumbent(final String incumbent) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setIncumbent(incumbent);
			}
		};
	}
	public static JobProperty position(final String position) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setPosition(position);
			}
		};
	}
	public static JobProperty positionEntryDate(final LocalDate positionEntryDate) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setPositionEntryDate(positionEntryDate);
			}
		};
	}

	public static JobProperty company(final String company) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setCompany(company);
			}
		};
	}

	public static JobProperty businessUnit(final String businessUnit) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setBusinessUnit(businessUnit);
			}
		};
	}

	public static JobProperty division(final String division) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setDivision(division);
			}
		};
	}

	public static JobProperty department(final String department) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setDepartment(department);
			}
		};
	}

	public static JobProperty location(final String location) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setLocation(location);
			}
		};
	}

	public static JobProperty costcenter(final String costcenter) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setCostCenter(costcenter);
			}
		};
	}

	public static JobProperty timezone(final String timezone) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setTimezone(timezone);
			}
		};
	}

	public static JobProperty supervisor(final String supervisor) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setSupervisor(supervisor);
			}
		};
	}

	public static JobProperty jobClassification(final String jobClassification) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setJobClassification(jobClassification);
			}
		};
	}

	public static JobProperty positionTitle(final String positionTitle) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setPositionTitle(positionTitle);
			}
		};
	}

	public static JobProperty localJobTitle(final String localJobTitle) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setLocalJobTitle(localJobTitle);
			}
		};
	}

	public static JobProperty payGrade(final String payGrade) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setPayGrade(payGrade);
			}
		};
	}

	public static JobProperty isRegular(final boolean isRegular) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setRegular(isRegular);
			}
		};
	}

	public static JobProperty standardWeeklyHours(final Integer standardWeeklyHours) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setStandardWeeklyHours(standardWeeklyHours);
			}
		};
	}

	public static JobProperty FTE(final Double FTE) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setFTE(FTE);
			}
		};
	}

	public static JobProperty isFulltime(final boolean isFulltime) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setFulltime(isFulltime);
			}
		};
	}

	public static JobProperty employeeClass(final String employeeClass) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEmployeeClass(employeeClass);
			}
		};
	}

	public static JobProperty shiftCode(final String shiftCode) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setShiftCode(shiftCode);
			}
		};
	}

	public static JobProperty fslaStatus(final String fslaStatus) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setFslaStatus(fslaStatus);
			}
		};
	}

	public static JobProperty jobEntryDate(final LocalDate jobEntryDate) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setJobEntryDate(jobEntryDate);
			}
		};
	}

	public static JobProperty leaveOfAbsenceStartDate(final String leaveOfAbsenceStartDate) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setLeaveOfAbsenceStartDate(leaveOfAbsenceStartDate);
			}
		};
	}

	public static JobProperty leaveOfAbsenceReturnDate(final String leaveOfAbsenceEndDate) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setLeaveOfAbsenceReturnDate(leaveOfAbsenceEndDate);
			}
		};
	}

	public static JobProperty lmsJobCode(final Integer lmsJobCode) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setLmsJobCodeID(lmsJobCode);
			}
		};
	}

	public static JobProperty eeoJobGroup(final String eeoJobGroup) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEeoJobGroup(eeoJobGroup);
			}
		};
	}

	public static JobProperty eeoCategory1(final String eeoCategory1) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEeoCategory1(eeoCategory1);
			}
		};
	}

	public static JobProperty eeoCategory4(final String eeoCategory4) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEeoCategory4(eeoCategory4);
			}
		};
	}

	public static JobProperty eeoCategory5(final String eeoCategory5) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEeoCategory5(eeoCategory5);
			}
		};
	}

	public static JobProperty eeoCategory6(final String eeoCategory6) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setEeoCategory6(eeoCategory6);
			}
		};
	}

	public static JobProperty dateOfBirth(final LocalDate dateOfBirth) {
		return new JobProperty() {
			@Override
			public void apply(JobProvider job, BaseProducer baseProducer) {
				job.setDateOfBirth(dateOfBirth);
			}
		};
	}


}
