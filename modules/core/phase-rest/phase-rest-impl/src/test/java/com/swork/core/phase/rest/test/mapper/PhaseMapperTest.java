package com.swork.core.phase.rest.test.mapper;

import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.internal.mapper.PhaseManageMapper;
import com.swork.core.phase.rest.internal.mapper.PhaseMapper;
import com.swork.core.phase.rest.test.mockdata.PhaseEntryMockData;
import com.swork.core.phase.rest.test.mockdata.PhaseMockDataUtil;
import com.swork.core.phase.service.mapper.model.PhaseMapperModel;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.model.PhaseEntryWrapper;
import com.swork.core.phase.service.service.PhaseManageEntryLocalService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PhaseMapperTest {
    @InjectMocks
    PhaseMapper phaseMapper;
    @Mock
    private PhaseManageEntryLocalService phaseManageEntryLocalService;
    @Mock
    private PhaseManageMapper phaseManageMapper;
    @Rule


    @Test
    public void testMapModelFromDto(){
        Phase phase= PhaseMockDataUtil.buildPhase();
        PhaseMapperModel phaseMapperModel=phaseMapper.mapModelFromDto(phase);
        assertEquals(phase.getName(),phaseMapperModel.getName());
        assertEquals((long) phase.getProjectId(),phaseMapperModel.getProjectId());
        assertEquals(phase.getStatus().toString(),phaseMapperModel.getStatus());
        assertEquals(phase.getDescription(),phaseMapperModel.getDescription());
        assertEquals(phase.getStartDate(),phaseMapperModel.getStartDate());
        assertEquals(phase.getEndDate(),phaseMapperModel.getEndDate());
        assertEquals(phase.getManages(),phaseMapperModel.getManages());
    }

    @Test
    public void testMapDTOFromEntry(){
        PhaseEntry phaseEntry=new PhaseEntryWrapper(new PhaseEntryMockData());
        phaseEntry.setPhaseId(1L);
        phaseEntry.setExternalReferenceCode("ABC");
        phaseEntry.setPhaseName("Phase A");
        phaseEntry.setDescription("Description");
        phaseEntry.setStartDate(new Date(2003,02,01));
        phaseEntry.setEndDate(new Date(2005,03,01));
        phaseEntry.setProgress(1L);
        Phase phase=phaseMapper.mapDTOFromEntry(phaseEntry);
        assertEquals(phaseEntry.getPhaseId(),(long) phase.getId());
        assertEquals(phaseEntry.getExternalReferenceCode(),phase.getExternalReferenceCode());
        assertEquals(phaseEntry.getPhaseName(),phase.getName());
        assertEquals(phaseEntry.getDescription(),phase.getDescription());
        assertEquals(phaseEntry.getStartDate(), phase.getStartDate());
        assertEquals(phaseEntry.getEndDate(),phase.getEndDate());
        assertEquals(phaseEntry.getProgress(),(long) phase.getProgress());
    }

}
