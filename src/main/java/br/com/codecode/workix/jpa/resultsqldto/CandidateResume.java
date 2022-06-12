package br.com.codecode.workix.jpa.resultsqldto;

public class CandidateResume {
    public Long id;
    public String name;
    public String objective;

    public CandidateResume(Long id, String name, String objective) {
        this.id = id;
        this.name = name;
        this.objective = objective;
    }
}
