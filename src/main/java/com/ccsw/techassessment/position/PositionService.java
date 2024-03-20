package com.ccsw.techassessment.position;

import com.ccsw.techassessment.position.model.Position;
import com.ccsw.techassessment.position.model.PositionDto;
import com.ccsw.techassessment.position.model.PositionSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PositionService {

    /**
     * Find a page of positions
     * @param dto
     * @return {@link Page} of {@link Position}
     */
    Page<Position> findPage(PositionSearchDto dto);

    /**
     * Get a Position by id
     * @param id
     * @return {@link Position}
     */
    Position getPosition(Long id);

    /**
     * Get all Positions
     *
     * @return {@link List} of {@link Position}
     */
    List<Position> getAllPositions();

    /**
     * Save or update a Position
     * @param positionDto
     */
    void savePosition(Long id, PositionDto positionDto) throws Exception;

    /**
     * Delete a Position
     * @param id
     */
    void deletePosition(Long id) throws Exception;

}
