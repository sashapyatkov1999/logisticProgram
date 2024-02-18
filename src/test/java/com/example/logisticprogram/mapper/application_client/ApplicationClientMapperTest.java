package com.example.logisticprogram.mapper.application_client;

import com.example.logisticprogram.dto.request.application_client.ApplicationClientAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationClientMapperTest {
    @InjectMocks
    private ApplicationClientMapper mapper;
    private final Long APPLICATION_ID = 1L;
    private final Long CLIENT_ID = 2L;
    private final String DESCRIPTION = "";

    @Test
     void from() {

        var source = spy(getApplicationClientAddRequest());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source).getApplicationId();
        verify(source).getClientId();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }
    @Test
    void fromList(){
        var source = spy(getApplicationClientAddRequest());
        var resultList = mapper.from(List.of(source,source,source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source,times(3)).getApplicationId();
        verify(source,times(3)).getClientId();
        verify(source,times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }


    private ApplicationClientAddRequest getApplicationClientAddRequest(){
        return new ApplicationClientAddRequest()
                .setApplicationId(APPLICATION_ID)
                .setClientId(CLIENT_ID)
                .setDescription(DESCRIPTION);
    }
}
