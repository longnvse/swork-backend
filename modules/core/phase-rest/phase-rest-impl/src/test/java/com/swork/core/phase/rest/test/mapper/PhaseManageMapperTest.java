package com.swork.core.phase.rest.test.mapper;

import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.phase.rest.dto.v1_0.PhaseManage;
import com.swork.core.phase.rest.internal.mapper.PhaseManageMapper;
import com.swork.core.phase.rest.test.mockdata.PhaseManageEntryMockData;
import com.swork.core.phase.service.model.PhaseManageEntry;
import com.swork.core.phase.service.model.PhaseManageEntryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PhaseManageMapperTest {
    @InjectMocks
    private PhaseManageMapper phaseManageMapper;
    @Test
    public void testMapFromEntry(){
        PhaseManageEntry phaseManageEntry=new PhaseManageEntryWrapper(new PhaseManageEntryMockData());
        phaseManageEntry.setPhaseManageId(1L);
        phaseManageEntry.setPhaseId(1L);
        phaseManageEntry.setAccountId(1L);
        PhaseManage phaseManage=phaseManageMapper.mapFromEntry(phaseManageEntry);
        assertEquals(phaseManageEntry.getPhaseManageId(),(long) phaseManage.getId());
        assertEquals(phaseManageEntry.getPhaseId(),(long) phaseManage.getPhaseId());
        assertEquals(phaseManageEntry.getAccountId(),(long) phaseManage.getAccountId());
    }

    @Test
    public void testMapFromEntries(){
        PhaseManageEntry phaseManageEntry=new PhaseManageEntryWrapper(new PhaseManageEntryMockData());
        phaseManageEntry.setPhaseManageId(1L);
        phaseManageEntry.setPhaseId(1L);
        phaseManageEntry.setAccountId(1L);
        List<PhaseManageEntry> phaseManageEntries=new ArrayList<>();
        phaseManageEntries.add(phaseManageEntry);

        PhaseManage[] phaseManages=phaseManageMapper.mapFromEntries(phaseManageEntries);
        assertEquals(phaseManageEntries.get(0).getPhaseManageId(),(long) phaseManages[0].getId());
        assertEquals(phaseManageEntries.get(0).getPhaseId(),(long) phaseManages[0].getPhaseId());
        assertEquals(phaseManageEntries.get(0).getAccountId(),(long) phaseManages[0].getAccountId());
    }
}
