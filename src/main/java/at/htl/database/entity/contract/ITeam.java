package at.htl.database.entity.contract;

public interface ITeam extends IEntity<ITeam>{
    void setName(String name);
    String getName();
    static void merge(ITeam t1, ITeam t2){
        if(t2.getName() != null)
            t1.setName(t2.getName());
    }
}
