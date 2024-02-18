package com.example.logisticprogram.mapper.application_client;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationClientResponseMapperTest {
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;

    @Mock
    private UserResponseMapper clientResponseMapper;

    @InjectMocks
    private ApplicationClientResponseMapper mapper;

    private final Long ID = 0L;
    private final Long APPLICATION_ID = 1L;
    private final Long CLIENT_ID = 2L;
    private final String DESCRIPTION = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();


    @Test
    void from() {
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));
        when(clientResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(CLIENT_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getApplication();
        verify(source).getId();
        verify(source).getClient();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verify(clientResponseMapper).from(any(User.class));
        verify(applicationResponseMapper).from(any(Application.class));

        verifyNoMoreInteractions(source);

    }
    @Test
    void fromList() {
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));
        when(clientResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(CLIENT_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source,source,source));
        assertThat(resultList).isNotEmpty();
        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getApplication();
        verify(source,times(3)).getId();
        verify(source,times(3)).getClient();
        verify(source,times(3)).getDescription();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(clientResponseMapper,times(3)).from(any(User.class));
        verify(applicationResponseMapper,times(3)).from(any(Application.class));

        verifyNoMoreInteractions(source);

    }
    private ApplicationClient source(){
        ApplicationClient source = new ApplicationClient();
        return source
                .setId(ID)
                .setApplication(new Application(APPLICATION_ID))
                .setClient(new User(CLIENT_ID))
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}