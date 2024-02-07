package com.ccsw.dashboard.profile.model;

import java.util.List;

import com.ccsw.dashboard.graderole.model.GradeTotal;

public class InformeRoles {

	List<List<ProfileTotal>> profileTotal;
	List<GradeTotal> gradeTotal;

	public List<GradeTotal> getGradeTotal() {
		return gradeTotal;
	}

	public void setGradeTotal(List<GradeTotal> gradeTotal) {
		this.gradeTotal = gradeTotal;
	}

	public List<List<ProfileTotal>> getProfileTotal() {
		return profileTotal;
	}

	public void setProfileTotal(List<List<ProfileTotal>> profileTotal) {
		this.profileTotal = profileTotal;
	}
}
