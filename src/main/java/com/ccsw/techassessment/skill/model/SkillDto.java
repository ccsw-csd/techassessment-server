package com.ccsw.techassessment.skill.model;

import java.util.List;

public class SkillDto {

        private Long id;
        private String group;
        private String label;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

}