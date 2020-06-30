package no.responseweb.imagearchive.filestoredbservice.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FileStore {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "no.responseweb.imagearchive.filestoredbservice.config.UseExistingOrGenerateUUIdGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    private String baseServer;
    private String baseShare;
    private String baseFolder;

    @Column(unique = true)
    private String nickname; // TODO: Replace with tags?

    private String mountPoint;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime latestRefresh;

}
