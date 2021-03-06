package ru.sberbank.socialnetwork.message.domains;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.sberbank.socialnetwork.message.dto.MessageDTO;

import java.time.LocalDateTime;

@Document(collection = "message")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Message {
    @Id
    private String id;

    @NonNull
    private String content;

    @NonNull
    private String userId;

    @NonNull
    private String chatId;

    private LocalDateTime createdDate = LocalDateTime.now();

}
