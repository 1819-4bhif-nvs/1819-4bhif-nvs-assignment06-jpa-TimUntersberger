package at.htl.database.entity.contract;

public interface IProject extends IEntity<IProject>{
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    static void merge(IProject p1, IProject p2){
        if(p2.getName() != null)
            p1.setName(p2.getName());
        if(p2.getDescription() != null)
            p1.setDescription(p2.getDescription());
    }
}
