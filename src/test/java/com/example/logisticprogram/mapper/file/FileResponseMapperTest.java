package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileResponseMapperTest {
    @InjectMocks
    private FileResponseMapper mapper;

    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private PointResponseMapper pointResponseMapper;
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;

    private static final Long ID = 0L;
    private static final Long USER_ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final Long POINT_ID = 2L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "NAME";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        when(pointResponseMapper.from(any(Point.class))).thenReturn(new PointResponse().setId(POINT_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getUser();
        verify(source).getPoint();
        verify(source).getId();
        verify(source).getApplication();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verify(applicationResponseMapper).from(any(Application.class));
        verify(userResponseMapper).from(any(User.class));
        verify(pointResponseMapper).from(any(Point.class));

        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList()
    {
        when(pointResponseMapper.from(any(Point.class))).thenReturn(new PointResponse().setId(POINT_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getUser();
        verify(source,times(3)).getPoint();
        verify(source,times(3)).getId();
        verify(source,times(3)).getApplication();
        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(applicationResponseMapper,times(3)).from(any(Application.class));
        verify(userResponseMapper,times(3)).from(any(User.class));
        verify(pointResponseMapper,times(3)).from(any(Point.class));

        verifyNoMoreInteractions(source);
    }
    private File source(){
        return new File()
                .setId(ID)
                .setUser(new User(USER_ID))
                .setApplication(new Application(APPLICATION_ID))
                .setPoint(new Point(POINT_ID))
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
