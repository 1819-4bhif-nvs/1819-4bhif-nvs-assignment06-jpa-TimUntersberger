package at.htl.database.entity.contract;

import java.time.LocalDate;

public interface IVacation extends IEntity<IVacation> {
    void setStart(LocalDate start);
    LocalDate getStart();
    void setEnd(LocalDate End);
    LocalDate getEnd();
    void setApproved(Boolean isApproved);
    Boolean getApproved();
    void setPaid(Boolean isPaid);
    Boolean getPaid();

    static void merge(IVacation v1, IVacation v2) {
        if(v2.getApproved() != null){
            v1.setApproved(v2.getApproved());
        }
        if(v2.getStart() != null){
            v1.setStart(v2.getStart());
        }
        if(v2.getEnd() != null){
            v1.setEnd(v2.getEnd());
        }
        if(v2.getPaid() != null){
            v1.setPaid(v2.getPaid());
        }
    }

}
