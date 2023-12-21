package fluffysnow.idearly.problem.domain;


import fluffysnow.idearly.competition.domain.Competition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JoinColumn(name = "competition_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Competition competition;

    @OneToMany(mappedBy = "problem")
    private List<Testcase> testcases;

    public void updateProblem(String name, String description){
        this.name = name;
        this.description = description;
    }
}
