package br.com.codecode.workix.jpa.resultsqldto;

import br.com.codecode.workix.jpa.models.CarrerLevel;
import br.com.codecode.workix.jpa.models.Presence;

public class ResumeWithCandidateShort {
    public Long id;
    public String objective;
    public CarrerLevel carrerLevel;
    public Presence presence;
    public Long candidateId;
    public String name;

    public ResumeWithCandidateShort(Long id, String objective, int carrerLevel, int presence, Long candidateId, String name) {
        this.id = id;
        this.objective = objective;
        this.carrerLevel = CarrerLevel.values()[carrerLevel];
        this.presence = Presence.values()[presence];
        this.candidateId = candidateId;
        this.name = name;
    }
}
