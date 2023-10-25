package sukko.taxidermy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sukko.config.BaseEntity;
import sukko.expedition.domain.entity.LoaCharacter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Taxidermy extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "longtext")
    private String content;
    @Enumerated(EnumType.STRING)
    private DungeonType dungeonType;
    private String password;
    @ManyToOne
    private LoaCharacter prisoner;

    @Builder
    public Taxidermy(String title, String content, DungeonType dungeonType, String password, LoaCharacter prisoner) {
        this.title = title;
        this.content = content;
        this.dungeonType = dungeonType;
        this.password = password;
        this.prisoner = prisoner;
    }
}
