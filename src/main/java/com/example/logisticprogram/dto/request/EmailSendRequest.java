package com.example.logisticprogram.dto.request;

import com.example.logisticprogram.utils.Pair;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
public class EmailSendRequest {

    private String subject;
    private String text;

    private List<String> to = Collections.emptyList();
    private List<String> cc = Collections.emptyList();
    private List<String> bcc = Collections.emptyList();

    private List<Pair<String, File>> attachments = Collections.emptyList();
}
