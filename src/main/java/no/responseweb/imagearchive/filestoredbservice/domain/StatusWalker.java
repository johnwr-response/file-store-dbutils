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
public class StatusWalker {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", nullable = false)
    private UUID walkerInstanceToken;

    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", nullable = false)
    private UUID fileStoreId;

    private Boolean ready;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime runningSince;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastFinished;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastActiveDate;
}
