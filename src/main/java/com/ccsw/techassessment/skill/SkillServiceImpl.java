package com.ccsw.techassessment.skill;


import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import com.ccsw.techassessment.skill.model.SkillSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class SkillServiceImpl implements SkillService{

    @Autowired
    SkillRepository skillRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Skill> findPage(SkillSearchDto dto) {

        return this.skillRepository.findAll(dto.getPageable().getPageable());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Skill getSkill(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSkill(Long id, SkillDto dto) throws Exception {

        Skill skill;

        if(id == null){
            skill = new Skill();

        } else {
            //Si no existe el id lanza error

            skill = skillRepository.findById(id).orElseThrow(() -> new Exception("Skill not found"));
        }

        skill.setGroup(dto.getGroup());
        skill.setLabel(dto.getLabel());

        skillRepository.save(skill);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteSkill(Long id) throws Exception {

        if(skillRepository.findById(id).orElse(null) == null){
            throw new Exception("Skill not found");
        }

        skillRepository.deleteById(id);
    }


}

