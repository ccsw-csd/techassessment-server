package com.ccsw.techassessment.position;

import com.ccsw.techassessment.position.model.Position;
import com.ccsw.techassessment.position.model.PositionDto;
import com.ccsw.techassessment.position.model.PositionSearchDto;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;
import org.dozer.DozerBeanMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/position")
@RestController
public class PositionController {
    private PositionService positionService;
    private DozerBeanMapper mapper;

    @Autowired
    public PositionController(PositionService positionService, DozerBeanMapper mapper) {
        this.positionService = positionService;
        this.mapper = mapper;
    }

    @Operation(summary = "Page of Positions", description = "Method that return a page of Positions")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PositionDto> findPage(@RequestBody PositionSearchDto dto) {

        Page<Position> page = this.positionService.findPage(dto);

        return new PageImpl<>(
                page.getContent().stream().map(position -> mapper.map(position, PositionDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "Position by id", description = "Method that return a position by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PositionDto getPosition(@PathVariable("id") Long id) {
        return mapper.map(positionService.getPosition(id), PositionDto.class);
    }

    @Operation(summary = "All positions", description = "Method that return all positions")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PositionDto> getAllPositions() {
        List<Position> positions = positionService.getAllPositions();
        return positions.stream().map(position -> mapper.map(position, PositionDto.class)).toList();
    }

    @Operation(summary = "New Position", description = "Method that create a new Position")
    @RequestMapping(path ={"/new"}, method = RequestMethod.POST)
    public void newPosition(@RequestBody PositionDto dto) throws Exception {
        positionService.savePosition(null,dto);
    }

    @Operation(summary = "Update", description = "Method that update a Position")
    @RequestMapping(path ={"","/{id}"}, method = RequestMethod.PUT)
    public void updatePosition(@PathVariable(name = "id", required = false) Long id, @RequestBody PositionDto dto) throws Exception {
        positionService.savePosition(id, dto);
    }

    @Operation(summary = "Delete Position", description = "Method that delete a Position")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePosition(@PathVariable("id") Long id) throws Exception {
        positionService.deletePosition(id);
    }


}
