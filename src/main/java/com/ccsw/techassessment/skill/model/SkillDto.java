package com.ccsw.techassessment.skill.model;

import java.util.List;

public class SkillDto {

        private Long id;
        private String skillGroup;
        private String label;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSkillGroup() {
            return skillGroup;
        }

        public void setSkillGroup(String skillGroup) {
            this.skillGroup = skillGroup;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

}