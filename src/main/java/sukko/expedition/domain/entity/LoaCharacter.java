package sukko.expedition.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sukko.config.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoaCharacter extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ServerType serverType;
    @Enumerated(EnumType.STRING)
    private ClassType classType;
    private String name;
    @ManyToOne
    private Expedition expedition;

    public static LoaCharacter createLoaCharacter(Expedition expedition, ServerType serverType, ClassType classType, String name){
        return LoaCharacter.builder()
                .expedition(expedition)
                .serverType(serverType)
                .classType(classType)
                .name(name)
                .build();
    }

    @Builder
    public LoaCharacter(Expedition expedition, ServerType serverType, ClassType classType, String name) {
        this.expedition = expedition;
        this.serverType = serverType;
        this.classType = classType;
        this.name = name;
    }
}
