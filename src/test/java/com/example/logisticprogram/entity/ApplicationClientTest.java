package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationClientTest extends BaseEntityTest {

    private static final Long ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final Long CLIENT_ID = 2L;
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);
    @BeforeAll
    void init() throws ClassNotFoundException {
        checkNumFields(7);
    }

    @Test
    void testNoArgsConstructor(){

        var result = getApplicationClient();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);

    }

    private ApplicationClient getApplicationClient() {
        return new ApplicationClient()
                .setId(ID)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setClient(client())
                .setApplication(application());


    }

    private Application application(){
        return new Application()
                .setId(APPLICATION_ID);
    }
    private User client(){
        return new User()
                .setId(CLIENT_ID);
    }

}
