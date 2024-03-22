package com.ccsw.techassessment.position;


import com.ccsw.techassessment.common.criteria.SearchCriteria;
import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import com.ccsw.techassessment.exception.RequiredSkillException;
import com.ccsw.techassessment.position.model.FiltersDto;
import com.ccsw.techassessment.position.model.Position;
import com.ccsw.techassessment.position.model.PositionDto;
import com.ccsw.techassessment.position.model.PositionSearchDto;

import com.ccsw.techassessment.skill.SkillService;
import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PositionServiceImpl implements PositionService{

    private PositionRepository positionRepository;
    private SkillService skillService;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository, SkillService skillService) {
        this.positionRepository = positionRepository;
        this.skillService = skillService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Position> findPage(PositionSearchDto dto) {

        FiltersDto filtros = dto.getFilterParams();

        if(filtros == null){
            return this.positionRepository.findAll(null, dto.getPageable().getPageable());
        }

        PositionSpecification clientSpec = new PositionSpecification(new SearchCriteria("client", ":", filtros.getClient() ));

        Specification<Position> spec = Specification.where(clientSpec);


        return this.positionRepository.findAll(spec, dto.getPageable().getPageable());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Position getPosition(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Position> getAllPositions() {
        return (List<Position>) positionRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePosition(Long id, PositionDto dto) throws Exception{

        Position position;

        if(id != null){
            position = positionRepository.findById(id).orElse(null);
        } else {
            position = new Position();
        }

        position.setRequest(dto.getRequest());
        position.setClient(dto.getClient());
        position.setGrade(dto.getGrade());

        List<Skill> skills = new ArrayList<>();
        for(SkillDto skillDto : dto.getSkill()){
            Skill skill = skillService.getSkill(skillDto.getId());
            if(skill == null){
                throw new NotFoundException("Skill not found");
            }
            skills.add(skill);
        }
        position.setSkill(skills);


        if(skills == null || skills.isEmpty()){
            throw new RequiredSkillException("At least, one skill is required");
        }

        if(dto.getRequest() == null || dto.getRequest().isEmpty() || dto.getClient() == null || dto.getClient().isEmpty() || dto.getGrade() == null || dto.getGrade().isEmpty()){
            throw new RequiredFieldsException("All fields are required");
        }

        positionRepository.save(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePosition(Long id) throws Exception {

        if(positionRepository.findById(id).orElse(null) == null){
            throw new NotFoundException("Position not found");
        }

        positionRepository.deleteById(id);
    }



}