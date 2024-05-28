package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleMapperTest {
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";


  @InjectMocks
  private RoleMapper mapper;

  @Test
  void from(){

      var source = spy(getRoleAddRequest());

      var result = mapper.from(source);

      assertThat(result.getId()).isNull();
      assertThat(result.getCreated()).isNull();
      assertThat(result.getModified()).isNull();
      assertThat(result.getName()).isEqualTo(NAME);
      assertThat(result.getDescription()).isEqualTo(DESCRIPTION);


      verify(source).getName();
      verify(source).getDescription();
      verifyNoMoreInteractions(source);


  }


  @Test
    void fromList(){

      var source = spy(getRoleAddRequest());

      var resultList = mapper.from(List.of(source, source,source));

      assertNotNull(resultList);
      assertEquals(3, resultList.size());

      var result = resultList.get(0);

      assertThat(result.getId()).isNull();
      assertThat(result.getCreated()).isNull();
      assertThat(result.getModified()).isNull();
      assertThat(result.getName()).isEqualTo(NAME);
      assertThat(result.getDescription()).isEqualTo(DESCRIPTION);


      verify(source, times(3)).getName();
      verify(source, times(3)).getDescription();
      verifyNoMoreInteractions(source);

  }



    private RoleAddRequest getRoleAddRequest(){
      return new RoleAddRequest()
              .setName(NAME)
              .setDescription(DESCRIPTION);
    }
}
